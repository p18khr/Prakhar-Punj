# Generated by Django 3.2.9 on 2021-11-14 12:38

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('shop', '0005_auto_20211114_1038'),
    ]

    operations = [
        migrations.AddField(
            model_name='cartitem',
            name='total',
            field=models.IntegerField(blank=True, null=True),
        ),
    ]
