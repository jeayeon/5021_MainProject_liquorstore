package shop.jy.controller;

import shop.jy.controller.shopaction.liquorAdd;
import shop.jy.controller.shopaction.liquorAdd_view;
import shop.jy.controller.shopaction.liquor_List;
import shop.jy.controller.shopaction.liquor_buyView;
import shop.jy.controller.shopaction.liquor_buyok;
import shop.jy.controller.shopaction.liquor_cartAdd;
import shop.jy.controller.shopaction.liquor_cartDel;
import shop.jy.controller.shopaction.liquor_cartMod;
import shop.jy.controller.shopaction.liquor_cartView;
import shop.jy.controller.shopaction.liquor_cartViewMod;
import shop.jy.controller.shopaction.liquor_directbuy;
import shop.jy.controller.shopaction.liquor_single;
import shop.jy.controller.shopaction.shopAction;

public class ActionFactoryShop {

	public static ActionFactoryShop af = null;

	private ActionFactoryShop() {

	}

	public static ActionFactoryShop getInstance() {
		if (af == null) {
			af = new ActionFactoryShop();
		}
		return af;
	}

	public shopAction Command(String command, String command2) {
		shopAction action = null;
		if (command.equals("liquor_add")) {
			action = new liquorAdd();
		} else if (command.equals("liquor_list")) {
			action = new liquor_List();
		} else if (command.equals("liquorAdd_view")) {
			action = new liquorAdd_view();
		} else if (command.equals("liquor_single")) {
			action = new liquor_single();
		} else if (command.equals("liquor_cartAdd")) {
			action = new liquor_cartAdd();
		} else if (command.equals("liquor_cartView")) {
			action = new liquor_cartView();
		} else if (command.equals("liquor_cartDel")) {
			action = new liquor_cartDel();
		} else if (command.equals("liquor_buyView")) {// 수량 수정버튼 누를시에도 input 객체를 받아와야해서 command2를 두개 만듬
			action = new liquor_buyView();
		} else if (command.equals("liquor_buyok")) {
			action = new liquor_buyok();
		} else if (command.equals("liquor_directbuy")) {
			action = new liquor_directbuy();
		} else if (command.equals("liquor_cartMod")) {
			action = new liquor_cartViewMod();
		} else if (command.equals("liquor_Cartquantitymod")) {
			action = new liquor_cartMod();
		}

		return action;
	}

}
