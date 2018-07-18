package com.anytec.sdproperty.controller;


import com.anytec.sdproperty.data.model.TbUser;
import com.anytec.sdproperty.data.vo.OutputUserVo;
import com.anytec.sdproperty.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

/**
 * @des: controller 基类
 * @author Administrator
 *
 */

@Controller
public class BaseWebPreController {
	private static final Logger logger = LoggerFactory.getLogger(BaseWebPreController.class);

	@Autowired
	private UserService mUserService;
//


	public TbUser getTbUser(HttpServletRequest request) {
		try {

			OutputUserVo vo = (OutputUserVo)request.getSession().getAttribute("OutputUserVo");

			TbUser user = mUserService.getUserById(vo.getId());

			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public OutputUserVo getOutputUserVo(HttpServletRequest request) {
		try {
			OutputUserVo vo = (OutputUserVo)(request.getSession().getAttribute("OutputUserVo"));
			return vo;
		} catch (Exception e) {
			return null;
		}
	}


}
