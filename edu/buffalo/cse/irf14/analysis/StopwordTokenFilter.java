package edu.buffalo.cse.irf14.analysis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import edu.buffalo.cse.irf14.util.StringPool;

public class StopwordTokenFilter extends TokenFilter {

	
	static {
		String stopwordList = "a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,"
				+ "because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,"
				+ "get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,"
				+ "let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,"
				+ "our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,"
				+ "these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,"
				+ "why,will,with,would,yet,you,your";
		String[] stopwordsArray = stopwordList.split(StringPool.COMMA);
		stopwords = new HashSet<String>(Arrays.asList(stopwordsArray));
	}
	
	public StopwordTokenFilter(TokenStream stream) {
		super(stream);
	}
	
	private static Set<String> stopwords;
	Token token;

	@Override
	public boolean increment() throws TokenizerException {
		if(ts.hasNext()) {
			token = ts.next();
			if(stopwords.contains(token.toString().toLowerCase())) {
				ts.remove();
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TokenStream getStream() {
		return ts;
	}

}