package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.WalletDao;
import entity.User;
import entity.Wallet;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("wallet");
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String userPhone = request.getParameter("logaccount");
		String userPassword = request.getParameter("logpassword");
		UserDao userDao = new UserDao();
		String password = userDao.getPassByPhone(userPhone);
		if(password==""||!password.equals(userPassword)){
			request.getRequestDispatcher("error.html").forward(request, response);
		}else {
			int userId = userDao.getUserIdByPhone(userPhone);
			HttpSession session = request.getSession();
			User user = userDao.getUserById(userId);
			session.setAttribute("user", user);
			WalletDao walletDao = new WalletDao();
			int balance = walletDao.getBalanceById(userId);
			if(balance==-1){
				walletDao.addWallet(new Wallet(userId,0));
			}else{
				session.setAttribute("wallet", new Wallet(userId, balance));
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
