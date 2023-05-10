package com.training.nagarro.ecommerce2.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.nagarro.ecommerce2.dao.CartRepository;
import com.training.nagarro.ecommerce2.dao.SaleRepository;
import com.training.nagarro.ecommerce2.model.Product;
import com.training.nagarro.ecommerce2.model.SaleReport;
import com.training.nagarro.ecommerce2.model.Sales;
import com.training.nagarro.ecommerce2.service.SalesService;

@Service
@Transactional
public class SalesServiceImpl implements SalesService {

	
	CartRepository crepo;
	SaleRepository repo;
	
	
	@Autowired
	public SalesServiceImpl(SaleRepository repo,CartRepository crepo) {
		this.repo = repo;
		this.crepo = crepo;
	}

	public SalesServiceImpl() {}

    public void sale(Sales s) {
		Double p = (s.getPrice() - (s.getPrice()*s.getDiscount())/100)*s.getQuantity();
    	s.setTotalPrice(p);
    	s.setOrderDate();
    	s.setOrderTime();
    	this.repo.save(s);
	}

	public List<Sales> get() {
		List<Sales> list = this.repo.find();
		return list;
	}

	public Sales getLatest(long iduser) {
		Sales s = this.repo.getOrder(iduser);
		return s;
	}

	public List<Sales> getUserOrders(long iduser) {
		List<Sales> list = this.repo.getOrders(iduser);
		
		return list;
	}

	
		public List<Sales> filterDate(String startDate, String endDate, long idvendor) {
		  List<Sales> list = this.repo.filter(startDate,endDate,idvendor);
		return list;
	}

		
		
      public List<String> getCategory() {
			List<String> list = this.repo.category();
			return list;
		}

	public List<String> getBrand() {
		List<String> list = this.repo.brand();
		return list;
	}

	public List<Sales> searchProduct(String name) {
	   List<Sales> list = this.repo.searchByKey(name);
	   return list;
	}

	public List<Sales> search(String brand, String category) {
		List<Sales> list = this.repo.search2(brand,category);
		return list;
	}

	public List<Sales> getLatestOnes(long iduser,int count) {
		List<Sales> list = this.repo.getLOrders(iduser, count);
		return list;
	}


}
