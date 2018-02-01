package com.wpi.teamd.servlet;

import com.wpi.teamd.dao.ServerInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class would process the lock seat request from web page.
 *
 * @author Zheng
 * @version 1.0
 * @since 2017-04-20
 *
 *
 *
 */
@WebServlet(name = "LockSeatServlet", urlPatterns = {"/LockSeat"})
public class LockSeatServlet extends HttpServlet {
	private static Logger logger = LogManager.getLogger(LockSeatServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseText = "";
		if (ServerInterface.lock()) {
			responseText = "1";
		} else {
			responseText = "0";
		}
//		logger.debug(responseText);
		response.setContentType("text/plain");
		response.getWriter().write(responseText);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
