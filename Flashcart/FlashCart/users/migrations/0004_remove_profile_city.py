# Generated by Django 3.2.9 on 2021-11-16 05:33

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0003_auto_20211116_1100'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='profile',
            name='city',
        ),
    ]
