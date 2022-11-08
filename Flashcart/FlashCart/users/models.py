from django.db import models

from django.contrib.auth.models import User
import uuid



class City(models.Model):
    name = models.CharField(max_length=200, null=True, blank=True)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.name)


class Profile(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE, null=True, blank=True)
    name = models.CharField(max_length=200, null=True, blank=True)
    phone = models.CharField(max_length=200, null=True, blank=True)
    addressLine1 = models.CharField(max_length=200, null=True, blank=True)
    addressLine2 = models.CharField(max_length=200, null=True, blank=True)
    city =  models.ForeignKey(City, on_delete=models.SET_NULL, null=True)
    pin = models.CharField(max_length=200, null=True, blank=True)
    timestamp =  models.DateTimeField(auto_now_add=True)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.user.username)



class Supplier(models.Model):
    profile = models.OneToOneField(Profile, on_delete=models.SET_NULL, null=True, blank=True)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.profile.user.username)


class Customer(models.Model):
    profile = models.OneToOneField(Profile, on_delete=models.SET_NULL, null=True, blank=True)
    id = models.UUIDField(default=uuid.uuid4, unique=True,
                          primary_key=True, editable=False)
    def __str__(self):
        return str(self.profile)