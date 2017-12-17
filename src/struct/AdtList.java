package struct;

/**
 * 线性表
 * 
 * @author Amy_oyzl
 *
 */
public interface AdtList {

	/**
	 * 是否为空
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 清空列表
	 */
	void clear();

	/**
	 * 添加一个元素
	 * 
	 * @param s
	 */
	void add(String s);

	/**
	 * 
	 * @param index
	 * @param s
	 */
	void add(int index, String s);

	/**
	 * 获得元素
	 * 
	 * @param index
	 * @return
	 */
	String get(int index);

	/**
	 * 删除元素
	 * 
	 * @param index
	 */
	String remove(int index);

	/*
	 * 获取列表长度
	 */
	int size();

}
