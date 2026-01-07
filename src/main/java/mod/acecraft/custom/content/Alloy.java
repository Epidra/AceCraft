package mod.acecraft.custom.content;

public record Alloy(int percent1, int percent2, String part1, String part2, int margin) {

	public String part(int i){
		return i == 0 ? part1 : part2;
	}
	
	public int percent(int i){
		return i == 0 ? percent1 : percent2;
	}
	
}
