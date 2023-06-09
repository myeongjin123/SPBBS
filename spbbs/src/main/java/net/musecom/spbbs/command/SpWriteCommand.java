package net.musecom.spbbs.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import net.musecom.spbbs.dao.SpDao;

public class SpWriteCommand implements SpCommand{
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest req =(HttpServletRequest) map.get("request");
		//�̸� ��й�ȣ ���� ����
		
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		SpDao dao = new SpDao();
		dao.write(uname, upass, title, content);
		
	}

}
