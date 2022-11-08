from django.contrib import admin

# Register your models here.
from . models import Profile, Supplier, Customer, City

admin.site.register(Profile)
admin.site.register(Supplier)
admin.site.register(Customer)
admin.site.register(City)