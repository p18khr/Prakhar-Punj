from django.shortcuts import render

from django.shortcuts import redirect
from django.contrib.auth import login, authenticate, logout
from django.contrib import messages
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required
from django.contrib.auth import logout

from users.models import City, Customer, Profile
from shop.models import CartItem, Category, HomePage, Order, Product

from . forms import CustomUserCreationForm, ProfileForm, CartItemForm




def userLogin(request):
    if request.user.is_authenticated: 
        return redirect('home')

    if request.method == "POST":
        username = request.POST['username']
        password = request.POST['password']
        try:
            user = User.objects.get(username=username)  
        except:
            messages.error(request, "username doesnt exixt!")
        user =  authenticate(request, username=username, password=password)
        if user is not None:
            login(request,user)
            return redirect('home')
        else:
            messages.error(request, "username or password is not correct")

    return render(request, 'ui/login.html')



def userRegister(request):
    page = 'register'
    form = CustomUserCreationForm()

    if request.method =='POST':
        form = CustomUserCreationForm(request.POST)
        if form.is_valid():
            user = form.save(commit=False)
            user.username = user.username.lower()
            user.save()

            profile = Profile.objects.create(user=user).save()

            Customer.objects.get_or_create(profile=profile)

            messages.success(request, 'User accout is created!')
            
            authenticated_user = authenticate(username=user.username,
                                      password=form.cleaned_data['password1'])

            login(request, authenticated_user)

            return redirect('profile')
        else:
            messages.error(request, "An error occured during registration")

    context = {'page':page, 'form':form}
    return render(request, 'ui/register.html', context)


   
@login_required(login_url='/')
def userProfile(request):
    profile = Profile.objects.filter(user = request.user).first()
    print(profile)
    form = ProfileForm(instance=profile)
    if request.method == 'POST':
        form = ProfileForm(request.POST, request.FILES, instance=profile)
        if form.is_valid():
            form.save()
            return redirect('profile')
    cities = City.objects.all()
    categories = Category.objects.all() 
    context = {'form':form, 'active':'profile', 'cities':cities,'categories':categories}
    return render(request, 'ui/profile.html',context)



def logoutUser(request):
    logout(request)
    return redirect('/')





@login_required(login_url='/')
def userHome(request):
    homepage = HomePage.objects.filter().first()
    products = homepage.products.all()
    cities = City.objects.all()
    categories = Category.objects.all() 
    context = {'active':'home','products':products,'cities':cities,'categories':categories}
    return render(request, 'ui/home.html',context=context)



@login_required(login_url='/')
def addToCart(request,productid):
    
    product = Product.objects.get(id=productid)

    if request.method == 'POST':
        qty = request.POST['qty']

        if int(product.stock) < int(qty):
            messages.error(request, "request quantity not available in the stock")
            context = {'product':product, 'active':'cart'}
            return render(request, 'ui/addtocart.html',context)
        else:
            pro = Profile.objects.get(user=request.user.id)
            cust = Customer.objects.filter(profile=pro).first()
            total = product.price * int(qty)
            cartitem = CartItem.objects.create(product=product, qty= qty, customer = cust, total=total )
            cartitem.save()
            product.stock = product.stock-int(qty)
            product.save()
            return redirect('cart')
    else:
        cities = City.objects.all()
        categories = Category.objects.all() 
        context = {'product':product, 'active':'cart','cities':cities,'categories':categories}
        return render(request, 'ui/addtocart.html',context)



@login_required(login_url='/')
def userCartRemoveItem(request,cartitemid):
    cartitem = CartItem.objects.get(id=cartitemid)
    product = Product.objects.get(id=cartitem.product.id)
    product.stock = product.stock + cartitem.qty
    product.save()
    cartitem.delete()

    messages.success(request, 'Item removed from cart!')
    pro = Profile.objects.get(user=request.user.id)
    cust = Customer.objects.filter(profile=pro).first()
    cartitems = CartItem.objects.filter(customer=cust).all()
    context = {'active':'cart','cartitems':cartitems}
    return render(request, 'ui/cart.html',context=context)



@login_required(login_url='/')
def userCart(request):
    pro = Profile.objects.get(user=request.user.id)
    cust = Customer.objects.filter(profile=pro).first()
    cartitems = CartItem.objects.filter(customer=cust).all()
    cities = City.objects.all()
    categories = Category.objects.all() 
    context = {'active':'cart','cartitems':cartitems, 'cities':cities,'categories':categories}
    return render(request, 'ui/cart.html',context=context)


@login_required(login_url='/')
def placeOrder(request):
    pro = Profile.objects.get(user=request.user.id)
    cust = Customer.objects.filter(profile=pro).first()
    cartitems = CartItem.objects.filter(customer=cust).all()

    for cartItem in cartitems:
        product = cartItem.product
        qty = cartItem.qty
        total =  cartItem.total
        Order.objects.create(customer = cust, product=product,qty = qty, total=total).save()
        CartItem.objects.get(id=cartItem.id).delete()

    return redirect('orders')
    


@login_required(login_url='/')
def userOrders(request):
    pro = Profile.objects.get(user=request.user.id)
    cust = Customer.objects.filter(profile=pro).first()

    orders = Order.objects.filter(customer=cust).all()

    cities = City.objects.all()
    categories = Category.objects.all()
    context = {'active':'orders','orders':orders, 'cities':cities,'categories':categories}
    return render(request, 'ui/orders.html',context=context)


@login_required(login_url='/')
def userShop(request):

    category = request.GET.get('category', None)
    city = request.GET.get('city', None)
    search = request.GET.get('search', None)
    
    cat = None
    cit = None
    if category == 'all':
        category = None
    
    if city == 'all':
        city = None

    print('category',category)
    print('city',city)
    print('search',search)

    products = Product.objects.all()

    if category:
        cat = Category.objects.get(id=category)
        products = products.filter(category=cat).all()

    
    if city:
        cit = City.objects.get(id=city)
        products = products.filter(supplier__profile__city=cit).all()
    
    if search:
        products = products.filter(name__contains=search).all()
        pass

    sl_cat = cat
    sl_city = cit
    
    cities = City.objects.all()
    categories = Category.objects.all() 

    context = {'active':'shop','products':products, 'cities':cities,'categories':categories, 'sl_cat':sl_cat, 'sl_city':sl_city, 'search':search }
    return render(request, 'ui/shop.html',context=context)