package shoppingcart1.servlet;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoppingcart1.model.Cart;

/*import cn.techtutorial.model.Cart;
import cn.techtutorial.servlet.ArrayList;
import cn.techtutorial.servlet.PrintWriter;*/


@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
    //   	out.print("add to cart servlet");

            ArrayList<Cart> cartList = new ArrayList<>();
            int id = Integer.parseInt(request.getParameter("id"));
            Cart cm = new Cart();
            cm.setId(id);
            cm.setQuantity(1);
            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
            if (cart_list == null) {
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                //out.println("Session created");
            }
            
            else{
            	cartList = cart_list;

                boolean exist = false;
                for (Cart c : cart_list) {
                    if (c.getId() == id) {
                        exist = true;
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
            }
                    if (!exist) {
                        cartList.add(cm);
                        //out.println("Product added");
                        response.sendRedirect("index.jsp");
                    }
                }
            }
            
        }
	}
}
        


