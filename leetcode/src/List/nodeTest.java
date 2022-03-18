package List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nodeTest {

	public static void main(String[] args) {
		List data=new ArrayList();
		Map node=new HashMap();
		node.put("name", "name");
		data.add(node);
		System.out.println(data);

		node=new HashMap();
		node.put("name", "hhh");
		data.add(node);
		System.out.println(data);

	}

}
