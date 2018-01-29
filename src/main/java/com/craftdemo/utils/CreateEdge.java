package com.craftdemo.utils;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
public class CreateEdge extends EvalFunc<String>
{       private final String CREATE="Create ";
        private final String OPEN_PARAN="(";
		private final String CLOSE_PARAN=")";
		private final String OPEN_SQUARE="[";
		private final String CLOSE_SQUARE="]";
		private final String COLON=":";
		private final String RELATION="->";
		private String edgeName;
		private String nodeSource;
		private String nodeSink;
		public CreateEdge( String edgeName,String nodeSource,String nodeSink){
			
			this.edgeName=edgeName;
			this.nodeSource=nodeSource;
			this.nodeSink=nodeSink;
			
		}
		
        public String exec(Tuple input) throws IOException {
                if (input == null ||  input.size()!=2 )
                    return null;
				
				if ((!StringUtils.isNotEmpty((String)input.get(0))) || (!StringUtils.isNotEmpty((String)input.get(1) )))
                		return null;
                StringBuilder result = new StringBuilder(CREATE+OPEN_PARAN+nodeSource+input.get(0)+CLOSE_PARAN+OPEN_SQUARE+COLON+edgeName+CLOSE_SQUARE+RELATION+OPEN_PARAN+nodeSink+input.get(1)+CLOSE_PARAN);
                
                return result.toString();
        }
}