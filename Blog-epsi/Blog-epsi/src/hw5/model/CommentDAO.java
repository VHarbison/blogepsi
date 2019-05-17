package hw5.model;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;


import hw5.databean.CommentBean;

public class CommentDAO extends GenericDAO<CommentBean> {

	public CommentDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(CommentBean.class, tableName, cp);
	}

	public void addToBottom(CommentBean item) throws RollbackException {
		try {
			Transaction.begin();

			// Get item at bottom of list
			CommentBean[] a = match(MatchArg.max("position"));

			CommentBean bottomBean;
			if (a.length == 0) {
				bottomBean = null;
			} else {
				bottomBean = a[0];
			}

			int newPos;
			if (bottomBean == null) {

				newPos = 1;
			} else {

				newPos = bottomBean.getPosition() + 1;
			}

			item.setPosition(newPos);


			create(item);

			Transaction.commit();
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}


	public CommentBean[] getComments() throws RollbackException {


		CommentBean[] comments = match();
		
		Arrays.sort(comments, (CommentBean i1, CommentBean i2) -> i1.getPosition() - i2.getPosition());

		return comments;
	}

}