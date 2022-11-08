from django.contrib import admin

from . models import Category, Product, CartItem, Cart, Order, HomePage

admin.site.register(Category)
admin.site.register(Product)
admin.site.register(CartItem)
admin.site.register(Cart)
admin.site.register(Order)
admin.site.register(HomePage)