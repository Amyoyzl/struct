package util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {
	public static void main(String[] args) {

		// treeSet();
		// list();
		map();

	}

	private static void map() {
		Song s1 = new Song("a", "a", 2017);
		Song s2 = new Song("b", "b", 2013);
		Song s3 = new Song("c", "c", 2016);
		Song s4 = new Song("c", "d", 2009);
		Song s5 = new Song("d", "a", 2017);

		TreeMap<String, Song> map = new TreeMap<>();
		map.put(s1.getTitle(), s1);
		map.put(s2.getTitle(), s2);
		map.put(s3.getTitle(), s3);
		map.put(s4.getTitle(), s4);
		map.put(s5.getTitle(), s5);

		// 三种视图
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map);

		Set<String> keys = map.keySet();
		for (String key : keys) {
			Song s = map.get(key);
			System.out.println(s);
		}

	}

	private static void list() {
		LinkedList<Song> list = new LinkedList<>();
		list.add(new Song("aaa", "ads", 2009));
		list.add(new Song("bbb", "bds", 2012));
		list.add(new Song("ccc", "eds", 2004));
		list.add(new Song("ddd", "dds", 2014));
		list.add(new Song("eee", "tds", 2018));

		for (Song song : list) {
			System.out.println(song);
		}

		Collections.sort(list);
		System.out.println("-------------------");
		// 洗牌
		// Collections.shuffle(list);
		// 翻转
		// Collections.reverse(list);
		// 截取子列表
		// List<Song> list2 = list.subList(0,list.size()/2);

		Song[] s = new Song[list.size() * 2];
		list.toArray(s);
		for (Song song : s) {
			System.out.println(song);
		}

		for (Song song : list) {
			System.out.println(song);
		}

	}

	private static void treeSet() {
		// 替换原有类中的比较方法
		Comparator<Song> comparator = new Comparator<Song>() {

			@Override
			public int compare(Song o1, Song o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		};
		TreeSet<Song> set = new TreeSet<>(comparator);

		// TreeSet<Song> set = new TreeSet<>(new Comparator<Song>() {
		//
		// @Override
		// public int compare(Song o1, Song o2) {
		// // TODO Auto-generated method stub
		// return 0;
		// }
		// });

		set.add(new Song("titlea", "artista", 2017));
		set.add(new Song("titlea", "find", 2005));
		set.add(new Song("art", "miss", 2005));
		set.add(new Song("ttif", "band", 2016));
		set.add(new Song("tttt", "destiny", 2018));

		// 迭代器
		Iterator<Song> iterator = set.iterator();
		while (iterator.hasNext()) {
			Song song = iterator.next();
			System.out.println(song);
		}

		// System.out.println(set.size());
		// for (Song song : set) {
		// System.out.println(song);
		// }
	}

}
