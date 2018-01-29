package com.craftdemo.utils;
import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.commons.lang.StringUtils;



public class CreateNode extends EvalFunc<String>
{       private final String CREATE="Create";
        private final String OPEN_PARAN="(";
		private final String CLOSE_PARAN=")";
		private final String OPEN_BRACE="{";
		private final String CLOSE_BRACE="}";
		private final String COLON=":";
		private final String COMMA=",";
		private String label;
		
		public CreateNode(String label) {
		       this.label=label.substring(0,label.length()-1)+"Id";
			   }
        public String exec(Tuple input) throws IOException {
                if (input == null|| input.size()<1)
                    return null;
                boolean isDataAvailable=false;
                StringBuilder result = new StringBuilder(CREATE+OPEN_PARAN+label+input.get(0)+COLON+label+OPEN_BRACE);
                for (int i=1;i<input.size();i++) {
                	if (!StringUtils.isNotEmpty((String)input.get(i)))
                		continue;
                    result.append(getInputSchema().getFields().get(i).alias);
                    result.append(COLON);
                    result.append(input.get(i));
                    isDataAvailable=true;
					if ( i < input.size()-1 )
					   result.append(COMMA);
                }
                if (!isDataAvailable)
                	return null;
                result.append(CLOSE_BRACE);
				result.append(CLOSE_PARAN);
				return result.toString();
        }
}