package hw5.model;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import hw5.databean.PostBean;

public class PostDAO extends GenericDAO<PostBean> {
	public PostDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(PostBean.class, tableName, cp);
	}

	public void addToTop(PostBean post) throws RollbackException {
		try {
			Transaction.begin();


			PostBean[] a = match(MatchArg.min("position"));

			PostBean topBean;
			if (a.length == 0) {
				topBean = null;
			} else {
				topBean = a[0];
			}

			int newPos;
			if (topBean == null) {

				newPos = 1;
			} else {

				newPos = topBean.getPosition() - 1;
			}

			post.setPosition(newPos);


			create(post);

			Transaction.commit();
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}


	public PostBean[] getPosts() throws RollbackException {


		PostBean[] items = match();
		
		Arrays.sort(items, (PostBean i1, PostBean i2) -> i1.getPosition() - i2.getPosition());

		return items;
	}

}