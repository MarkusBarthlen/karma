package de.barthlen.experiments;

import java.util.List;

import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.lang.java.ast.ASTImplementsList;
import net.sourceforge.pmd.lang.java.ast.JavaNode;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class SerializableIsMust extends AbstractJavaRule {

	/*
	 * public abstract class DBObject implements Serializable, Comparable {
	 * private static final long serialVersionUID = 8881702403894061327L; }
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.sourceforge.pmd.lang.java.rule.AbstractJavaRule#visit(net.sourceforge
	 * .pmd.lang.java.ast.ASTWhileStatement, java.lang.Object)
	 */

	/**
	 * ClassOrInterfaceDeclaration
	 */
	
	@Override
	public Object visit(ASTClassOrInterfaceDeclaration node, Object data) {
		
		final List<ASTImplementsList> interfacesParent = node.findChildrenOfType(ASTImplementsList.class);
		boolean ok = false;
		if(interfacesParent != null && interfacesParent.size() > 0){
			for(final ASTImplementsList node2 : interfacesParent){
				if(visitCheck(node2, null)){
					ok = true;
					break;
				}
			}
		}
		
		if(ok){
			System.out.println("Alles gut");
		} else {
			System.out.println("nee");
		}
		
		return visit((JavaNode) node, data);
	}
	
	
	public boolean visitCheck(ASTImplementsList node, Object data) {
        final List<ASTClassOrInterfaceType> interfaces = node.findChildrenOfType(ASTClassOrInterfaceType.class);
		
        boolean ok = false;
        if(interfaces != null && interfaces.size() > 0) {
			for(final ASTClassOrInterfaceType type : interfaces) {
				// One of these must have image Serializable
				if(type.getImage() != null && "Serializable".equals(type.getImage())){
					ok = true;
				}
			}
		}	
        
        return ok;
		// return visit((JavaNode) node, data);
	}
	
	
}