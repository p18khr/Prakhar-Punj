# Generated by Django 3.2.9 on 2021-11-14 13:22

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('shop', '0006_cartitem_total'),
    ]

    operations = [
        migrations.AddField(
            model_name='order',
            name='total',
            field=models.IntegerField(blank=True, null=True),
        ),
    ]
