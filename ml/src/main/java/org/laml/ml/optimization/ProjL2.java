package org.laml.ml.optimization;

import static org.laml.la.utils.InPlaceOperator.assign;
import static org.laml.la.utils.InPlaceOperator.times;
import static org.laml.la.utils.Matlab.norm;
import static org.laml.la.utils.Matlab.times;
import org.laml.la.matrix.Matrix;

/**
 * Compute proj_tC(X) where C = {X: || X ||_2 <= 1}.
 * 
 * @author Mingjie Qian
 * @version 1.0, Jan. 25th, 2014
 */
public class ProjL2 implements Projection {

	/**
	 * Compute proj_{tC}(X) where C = {X: || X ||_2 <= 1}.
	 * 
	 * @param t a nonnegative real scalar
	 * 
	 * @param X a real column matrix
	 * 
	 * @return proj_{tC}(X) where C = {X: || X ||_2 <= 1}
	 * 
	 */
	@Override
	public Matrix compute(double t, Matrix X) {
		double norm = norm(X, "fro");
		if (norm <= t) {
			return X;
		} else {
			return times(t / norm, X);
		}
	}

	/**
	 * Compute proj_{tC}(X) where C = {X: || X ||_2 <= 1}.
	 * 
	 * @param res result matrix
	 * 
	 * @param t a nonnegative real scalar
	 * 
	 * @param X a real column matrix
	 */
	@Override
	public void compute(Matrix res, double t, Matrix X) {
		double norm = norm(X, "fro");
		if (norm <= t) {
			assign(res, X);
		} else {
			times(res, t / norm, X);
		}
	}

}
