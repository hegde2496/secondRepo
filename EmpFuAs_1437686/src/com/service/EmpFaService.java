package com.service;

import java.util.ArrayList;

import com.bean.Faculty;
import com.dao.EmpFaDao;

public class EmpFaService {
	EmpFaDao da = new EmpFaDao();
	
	public ArrayList<Faculty> searchfac(String name){
		return da.searchfac(name);
	}

}
