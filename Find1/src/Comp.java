import java.util.ArrayList;
enum GenerateType { EQUAL, LARGE, LARGE_EQUEAL, LESS_EQUAL, LESS };
public interface Comp {
	static int TRUE = 0;
	static int FALSE = 1;
	static int ALL = 2;
	
	public int calc(int[] val, ArrayList<GenerateType>GenerateType_list,ArrayList<Integer> num_list);
	public int[] calc_arr(int[][] val,ArrayList<GenerateType>GenerateType_list,ArrayList<Integer> num_list);
	public int [][] generatePathCoverage(ArrayList<GenerateType>GenerateType_list,ArrayList<Integer> num_list);
	public int [][] generateMultiCoverage(ArrayList<GenerateType>GenerateType_list,ArrayList<Integer> num_list);
}
