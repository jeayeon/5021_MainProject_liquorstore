package shop.jy.controller;

import shop.jy.controller.action.Action;
import shop.jy.controller.action.Login;
import shop.jy.controller.action.Login_View;
import shop.jy.controller.action.Logout;
import shop.jy.controller.action.main_view;
import shop.jy.controller.action.userAdd;
import shop.jy.controller.action.userAdd_view;
import shop.jy.controller.action.userChk;

public class ActionFactory {

	public static ActionFactory af = null;

	private ActionFactory() {

	}

	public static ActionFactory getInstance() {
		if (af == null) {
			af = new ActionFactory();
		}
		return af;
	}
	
	
	public Action Command(String command) {
		Action action = null;
		if(command.equals("Login_view")) {
			action = new Login_View();
		}else if(command.equals("useradd")) {
			action = new userAdd();	
		}else if(command.equals("useradd_view")) {
			action = new userAdd_view();
		}else if(command.equals("insert_user")) {
			action = new userAdd();
		}else if(command.equals("userchk")) {
			action = new userChk();
		}else if(command.equals("Login")) {
			action = new Login();
		}else if(command.equals("Logout")) {
			action = new Logout();
		}else if(command.equals("main_view")) {
			action = new main_view();
		}
		
		return action;
	}



}
