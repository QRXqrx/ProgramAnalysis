package constantpropagation;

import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import soot.Unit;
import soot.tagkit.CodeAttribute;
import soot.tagkit.Tag;

/**
 * Represent an edge of a callgraph
 * @author Christian Adriano
 *
 */
public class Edge {

	public Unit startUnit; //source label
	public Unit endUnit; //destination label

	public String startLabel;
	public String endLabel;

	public Edge(Unit start,Unit end) {
		this.startUnit = start;
		this.endUnit = end;

		List<Tag> list;
		CodeAttribute tag;

		if(startUnit!=null){
			list = startUnit.getTags();
			tag = (CodeAttribute) list.get(0);
			this.startLabel = tag.getName();
		}

		if(endUnit!=null){
			list = endUnit.getTags();
			tag = (CodeAttribute) list.get(0);
			this.endLabel = tag.getName();
		}
	}

	/** format the edge to print it */
	public String toString(){
		return(getKey());
	}

	public String getKey(){
		return("("+startLabel+","+endLabel+")");
	}
}
