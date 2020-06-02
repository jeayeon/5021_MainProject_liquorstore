package shop.jy.controller;

import shop.jy.controller.boardaction.BoardAction;
import shop.jy.controller.boardaction.blog_Add;
import shop.jy.controller.boardaction.blog_AddView;
import shop.jy.controller.boardaction.blog_List;
import shop.jy.controller.boardaction.blog_singleview;

public class ActionFactoryBoard {

	public static ActionFactoryBoard af = null;

	private ActionFactoryBoard() {

	}

	public static ActionFactoryBoard getInstance() {
		if (af == null) {
			af = new ActionFactoryBoard();
		}
		return af;
	}

	public BoardAction Command(String command) {
		BoardAction action = null;
		if (command.equals("blog_List")) {
			action = new blog_List();
		} else if (command.equals("blog_AddView")) {
			action = new blog_AddView();
		} else if (command.equals("blog_Add")) {
			action = new blog_Add();
		} else if (command.equals("blog_singleview")) {
			action = new blog_singleview();
		}

		return action;
	}

}
