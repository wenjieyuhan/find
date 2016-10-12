import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class find1 {
	static int TRUE = 0;
	static int FALSE = 1;
	static int ALL = 2;
	enum GenerateType { EQUAL, LARGE, LARGE_EQUEAL, LESS_EQUAL, LESS };
	public ArrayList<Integer> num_list = new ArrayList<Integer>(); 
//	num_list.push(1);
	public ArrayList<GenerateType> GenerateType_list = new ArrayList<GenerateType>(); 
	int total;
	public find1(){
		//set up num; 16
		int arr[] = {1,3,5,7,9,3,2,5,1,6,4,2,3,6,9,10};
		for(int val: arr){
			num_list.add(val);
		}
		//set up type; 16
		GenerateType gt_arr[] = 
			{GenerateType.EQUAL,GenerateType.LARGE,GenerateType.EQUAL,GenerateType.LESS,
					GenerateType.LARGE,GenerateType.LARGE,GenerateType.LARGE,GenerateType.LESS_EQUAL,
					GenerateType.LESS_EQUAL,GenerateType.LESS_EQUAL,GenerateType.LARGE_EQUEAL,GenerateType.LESS,
					GenerateType.EQUAL,GenerateType.LARGE,GenerateType.LESS_EQUAL,GenerateType.LESS
			};
		for(GenerateType t : gt_arr){
			GenerateType_list.add(t);
		}
		//pick up the least num;
		total = num_list.size() >= GenerateType_list.size() ? GenerateType_list.size():num_list.size();
	}
	
	//transfer >, >= , <= , <, == to function.
	public boolean compare(int a, int b, GenerateType type){
		
		switch(type){
		case EQUAL:
			return (a == b);
		case LARGE: 
			return ( a > b );
		case LARGE_EQUEAL: 
			return ( a >= b );
		case LESS_EQUAL:
			return ( a <= b );
		case LESS:
			return ( a < b );
		default :
			return false;
		}
		
	}
	public int[] calc_arr(int[][] val,ArrayList<GenerateType>GenerateType_list,ArrayList<Integer> num_list) throws Exception {
		int[] result = new int[val.length];
		for(int i = 0; i < val.length; i++){
			result[i] = calc(val[i], GenerateType_list,num_list);
		}
		return result;
	}
	public int calc(int[] val, ArrayList<GenerateType>GenerateType_list,ArrayList<Integer> num_list) throws Exception{
		//inital num1;
		int num1 = 3;
	
		//caculate the result;
//		ArrayList<Boolean> result = new ArrayList<Boolean>();
		boolean[] result = new boolean[val.length];
		for(int i = 0; i < total; i++){
			result[i] = (compare(val[i], num_list.get(i),GenerateType_list.get(i)));
		}
		
//		System.out.println(Arrays.toString(result));
		
		// main body
		if(result[0] && result[1] && result[2]){
			if(result[3]){
				num1 = num1 * 2;
			}else{
				num1 += 2;
			}
		}else{
			if(result[4]){
				num1 +=3;
			}else{
				num1 -=2;
			}
		}
		
		
		if(result[5] || result[6]){
			num1 += 2;
		}else{
			if(result[7]){
				num1 +=1;
			}else{
				num1 +=3;
			}
		}
		

		if(result[8] && result[9]  || result[10] ){
			num1 -= 9;
		}else{
			if(result[11]|| result[12]){
				num1 += 5;
			}else{
				if(result[13]|| result[14]  && result[15]){
					num1 -= 6;
				}else{
					num1 *= 2;
				}
			}
		}
		return num1;
	}
	
	public int generat_test_num(GenerateType type, int pivot, boolean isRight){
		Random random = new Random();
		switch(type){
		case EQUAL:
			if(isRight){
				return pivot;
			}else{
				return pivot + (random.nextInt(10) + 1) * (random.nextInt(10) % 2 == 0 ? 1 : -1);
			}
		case LARGE: 
			if(isRight){
				return pivot + random.nextInt(10) + 1;
			}else{
				return pivot - random.nextInt(10);
			}
		case LARGE_EQUEAL: 
			
			if(isRight){
				return pivot + random.nextInt(10);
			}else{
				return pivot - random.nextInt(10) -1;
			}
			
		case LESS_EQUAL:
			if(isRight){
				return pivot - random.nextInt(10);
			}else{
				return pivot + random.nextInt(10) +1;
			}
		case LESS:
			if(isRight){
				return pivot - random.nextInt(10) -1;
			}else{
				return pivot + random.nextInt(10);
			}
		default :
			break;
		}
		return 0;
	}
	
	// according to isRightlist generate test_num randomly;
	public int[] generate_test_num_list(boolean[] list){
		int[] alist = new int[list.length];
		for(int i = 0; i < list.length; i++){
			alist[i] = (generat_test_num(GenerateType_list.get(i),num_list.get(i),list[i]));
		}
		return alist;
	}
	
	public int[][] generate_test_num_list_array(boolean[][] list){
		int[][] alist = new int[list.length][];
		for(int i =0; i < list.length; i++){
			alist[i] = generate_test_num_list(list[i]);
		}
		return alist;
	}
	//&& 0 || 1
	public int [][] generatePathCoverage() throws Exception{
		boolean T = true;
		boolean F = false;
//		find1 example = new find1();
		boolean[][] empty_len1 = {{F}};
		boolean[][] empty_len2 = {{F, F}};
		boolean[][] empty_len3 = {{F, F, F}};
		
		// path coverage
		//part1 
		boolean[][] node012_true = Tool.getArrayByAndAnd_RANDOM_ONE(TRUE);
		boolean[][] node012_false = Tool.getArrayByAndAnd_RANDOM_ONE(FALSE);
		
		boolean[][] node3_all = Tool.getArray(ALL);
		boolean[][] node4_all = Tool.getArray(ALL);
		
		boolean[][] part1 = Tool.Add(Tool.Cross_Join(Tool.Cross_Join(node012_true,node3_all),empty_len1),
				Tool.Cross_Join(Tool.Cross_Join(node012_false,empty_len1),node4_all)); 
//		//part2 
		boolean[][] node56_true = Tool.getArrayByOr_RANDOM_ONE(TRUE);
		boolean[][] node56_false = Tool.getArrayByOr_RANDOM_ONE(FALSE);
		
//		System.out.println(Arrays.toString(node56_true[0]));
		
		boolean[][] node7_all = Tool.getArray(ALL);
		boolean[][] part2 = 
				Tool.Add(
						Tool.Cross_Join(node56_true,empty_len1)
						,
						Tool.Cross_Join(node56_false,node7_all)
				); 

		boolean[][] part1_2 = Tool.Cross_Join(part1, part2); 

		
//		for(int p = 0; p < part1_2.length; p++){
//			System.out.println(Arrays.toString(part1_2[p]));		
//		}
		
		//part3
		boolean[][] node8910_true = Tool.getArrayByAndOR_RANDOM_ONE(TRUE);
		boolean[][] node8910_false = Tool.getArrayByAndOR_RANDOM_ONE(FALSE);
		
		boolean[][] node1112_true = Tool.getArrayByOr_RANDOM_ONE(TRUE);
		boolean[][] node1112_false = Tool.getArrayByOr_RANDOM_ONE(FALSE);
		
		boolean[][] node131415_true = Tool.getArrayByAndOR_RANDOM_ONE(TRUE);
		boolean[][] node131415_false = Tool.getArrayByAndOR_RANDOM_ONE(FALSE);
		boolean[][] node1314115_all = Tool.getArrayByAndOR_RANDOM_ONE(ALL);
		
		boolean[][] part3_1 = Tool.Cross_Join(new boolean[][][]{node8910_true,empty_len2,empty_len3});
	
		
		boolean[][] node1112131415_total = Tool.Add(
				Tool.Cross_Join(node1112_true, empty_len3), 
				Tool.Cross_Join(node1112_false,node1314115_all));
		
		
		boolean[][] part3 = Tool.Add(
				part3_1,
				Tool.Connect (
						node8910_false,
						node1112131415_total
						)
				);
//		System.out.println(part1.length+" "+part2.length+" "+part3.length);
		boolean[][] path_Testcase = Tool.Cross_Join(new boolean[][][] {part1, part2, part3});
		
//		System.out.println( path_Testcase.length + "....");
//		for(int p = 0; p < path_Testcase.length; p++){
//			System.out.println(Arrays.toString(path_Testcase[p]));		
//		}
				
		int arr[][] = generate_test_num_list_array(path_Testcase);
//		for(int p = 0; p < arr.length; p++){
//			System.out.println(Arrays.toString(arr[p]));		
//		}
//		int[] res  = calc_arr(arr);

		return arr;
	}
	public static void main(String[] args) throws Exception {
		find1 example = new find1();
		int[][] res = example.generatePathCoverage();
		int[] result = example.calc_arr(res, example.GenerateType_list,example.num_list);
		System.out.println(result.length);
		System.out.println(Arrays.toString(result));
		//del whatever you want
		int[][] new_res = Tool.DelTestCase(res, (int)(0.1* res.length));
		int[] result2 = example.calc_arr(new_res,example.GenerateType_list,example.num_list);
		System.out.println(result2.length);
		System.out.println(Arrays.toString(result2));	
	}
}
