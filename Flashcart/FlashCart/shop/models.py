from django.db import models
import uuid

from users.models import Customer, Supplier

class Category(models.Model):
    category = models.CharField(max_length=200, null=True, blank=True, unique=True)
    addedon =  models.DateTimeField(auto_now_add=True)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.category)


class Product(models.Model):
    supplier = models.ForeignKey(Supplier, on_delete=models.SET_NULL, null=True) 
    category = models.ForeignKey(Category, on_delete=models.SET_NULL, null=True)
    name = models.CharField(max_length=200, null=True, blank=True)
    product_image = models.ImageField(null=True, blank=True, 
                    upload_to='products/', default='products/default.png')
    description = models.CharField(max_length=500, null=True, blank=True)
    stock = models.IntegerField(null=True, blank=True)
    price = models.IntegerField(null=True, blank=True)
    addedon =  models.DateTimeField(auto_now_add=True)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.id)


class CartItem(models.Model):
    customer = models.ForeignKey(Customer, on_delete=models.SET_NULL, null=True) 
    product = models.ForeignKey(Product, on_delete=models.SET_NULL, null=True)
    qty = models.IntegerField(null=True, blank=True)
    total = models.IntegerField(null=True, blank=True)
    addedon =  models.DateTimeField(auto_now_add=True)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.id)


class Cart(models.Model):
    customer = models.ForeignKey(Customer, on_delete=models.SET_NULL, null=True) 
    cartitems = models.ManyToManyField(CartItem)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.id)


class Order(models.Model):
    customer = models.ForeignKey(Customer, on_delete=models.SET_NULL, null=True) 
    product = models.ForeignKey(Product, on_delete=models.SET_NULL, null=True)
    qty = models.IntegerField(null=True, blank=True)
    total = models.IntegerField(null=True, blank=True)
    purchaseon =  models.DateTimeField(auto_now_add=True)
    cancel = models.BooleanField(null=True, blank=True, default=False)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.id)


class HomePage(models.Model):
    products = models.ManyToManyField(Product)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.id)