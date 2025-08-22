package poly;

public class BeanFactory {
	
	public Object getBean (String beanName) {
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		} else if (beanName.equals("lg")) {
			return new LGTv();
		}
		return null;
	}
}
