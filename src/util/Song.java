package util;

public class Song implements Comparable<Song> {

	private String name;
	private String title;
	private int year;

	public Song(String title, String name, int year) {
		this.name = name;
		this.title = title;
		this.year = year;
	}

	public Song(String title, String name) {
		this.name = name;
		this.title = title;
	}

	@Override
	public int compareTo(Song o) {
		// return title.compareTo(o.title);
		if (year != o.year)
			return year - o.year;
		else {
			return title.compareTo(o.title);
		}
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return name;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Song:" + title + "," + name + "," + year;
	}

}
