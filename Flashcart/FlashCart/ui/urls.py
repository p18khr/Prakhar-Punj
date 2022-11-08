
from django.urls import path
from . import views

urlpatterns = [
    path('', views.userLogin, name='userlogin'),
    path('logout/', views.logoutUser, name='logout'),
    path('home/', views.userHome, name='home'),
    path('register/', views.userRegister, name='register'), 
    path('profile/', views.userProfile, name='profile'),
    path('addtocart/<str:productid>/', views.addToCart, name='addtocart'),
    path('cart/', views.userCart, name='cart'),
    path('removefromcart/<str:cartitemid>/', views.userCartRemoveItem, name='removefromcart'),
    path('placeorder/', views.placeOrder, name='placeorder'),
    path('orders/', views.userOrders, name='orders'),
    path('shop/', views.userShop, name='shop'),
]