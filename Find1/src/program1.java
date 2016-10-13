import java.util.ArrayList;
import java.util.Arrays;


public class program1 implements Comp{

	@Override
	public int calc(int[] val, ArrayList<GenerateType> GenerateType_list, ArrayList<Integer> num_list) {
		int num1 = 3;
		boolean[] result = new boolean[val.length];
		for(int i = 0; i < val.length; i++){
			result[i] = (Tool.compare(val[i], num_list.get(i), GenerateType_list.get(i)));
		}
		
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

	@Override
	public int[] calc_arr(int[][] val,ArrayList<GenerateType>GenerateType_list,ArrayList<Integer> num_list) {
		int[] result = new int[val.length];
		for(int i = 0; i < val.length; i++){
			result[i] = calc(val[i], GenerateType_list,num_list);
		}
		return result;
	}

	@Override
	public int[][] generatePathCoverage(ArrayList<GenerateType>GenerateType_list,ArrayList<Integer> num_list) {
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
		boolean[][] path_Testcase = Tool.Cross_Join(new boolean[][][] {part1, part2, part3});
		int arr[][] = Tool.generate_test_num_list_array(GenerateType_list,num_list,path_Testcase);
		return arr;
	}

	@Override
	public int[][] generateMultiCoverage(ArrayList<GenerateType>GenerateType_list,ArrayList<Integer> num_list) {
		// TODO Auto-generated method stub
		boolean T = true;
		boolean F = false;
		boolean[][] empty_len1 = {{F}};
		boolean[][] empty_len2 = {{F, F}};
		boolean[][] empty_len3 = {{F, F, F}};
		
		//part1 
		boolean[][] node012_true = Tool.getArrayByAndAnd(TRUE);
		boolean[][] node012_false = Tool.getArrayByAndAnd(FALSE);
		boolean[][] node3_all = Tool.getArray(ALL);
		boolean[][] node4_all = Tool.getArray(ALL);
		boolean[][] part1 = Tool.Add(
				Tool.Connect(new boolean[][][]{node012_true,node3_all,empty_len1})
				, 
				Tool.Connect(new boolean[][][]{node012_false, empty_len1,node4_all})
				);
		
		boolean[][] node56_true = Tool.getArrayByOr(FALSE);
		boolean[][] node56_false = Tool.getArrayByOr(FALSE);
		boolean[][] node7_all = Tool.getArray(ALL);
		
		boolean[][] part2 = Tool.Add(
				Tool.Connect(new boolean[][][]{node56_true,empty_len1})
				, 
				Tool.Connect(new boolean[][][]{node56_false,node7_all})
				);
		
		boolean[][] node8910_true = Tool.getArrayByAndOR_RANDOM_ONE(TRUE);
		boolean[][] node8910_false = Tool.getArrayByAndOR_RANDOM_ONE(FALSE);
		
		boolean[][] node1112_true = Tool.getArrayByOr_RANDOM_ONE(TRUE);
		boolean[][] node1112_false = Tool.getArrayByOr_RANDOM_ONE(FALSE);
		
		boolean[][] node131415_true = Tool.getArrayByAndOR_RANDOM_ONE(TRUE);
		boolean[][] node131415_false = Tool.getArrayByAndOR_RANDOM_ONE(FALSE);
		boolean[][] node1314115_all = Tool.getArrayByAndOR_RANDOM_ONE(ALL);
		
		boolean[][] part3_1 = Tool.Connect(new boolean[][][]{node8910_true,empty_len2,empty_len3});
	
		
		boolean[][] node1112131415_total = Tool.Add(
				Tool.Connect(node1112_true, empty_len3), 
				Tool.Connect(node1112_false,node1314115_all));
		
		boolean[][] part3 = Tool.Add(
				part3_1,
				Tool.Connect (
						node8910_false,
						node1112131415_total
						)
				);
		
		boolean[][] path_Testcase = Tool.Connect(new boolean[][][] {part1, part2, part3});
		int arr[][] = Tool.generate_test_num_list_array(GenerateType_list,num_list,path_Testcase);
		return arr;
	}

	public static void main(String[] args) {
			ArrayList<Integer> num_list = new ArrayList<Integer>(); 
			ArrayList<GenerateType> GenerateType_list = new ArrayList<GenerateType>(); 
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
			program1 example = new program1();
			
			
			int[][] res = example.generatePathCoverage(GenerateType_list, num_list);
			int[] result = example.calc_arr(res, GenerateType_list,num_list);
			System.out.println(result.length);
			System.out.println(Arrays.toString(result));
			
			//del whatever you want del 10%
			int[][] new_res = Tool.DelTestCase(res, (int)(0.1* res.length));
			int[] result2 = example.calc_arr(new_res,GenerateType_list,num_list);
			System.out.println(result2.length);
			System.out.println(Arrays.toString(result2));	
			
			int[][] res1 = example.generateMultiCoverage(GenerateType_list, num_list);
			int[] result1 = example.calc_arr(res1, GenerateType_list,num_list);
			System.out.println(result1.length);
			System.out.println(Arrays.toString(result1));
			
			//del whatever you want del 10%
			int[][] new_res1 = Tool.DelTestCase(res1, (int)(0.1* res1.length+1));
			int[] result3 = example.calc_arr(new_res1,GenerateType_list,num_list);
			System.out.println(result3.length);
			System.out.println(Arrays.toString(result3));	
			
			
	}
	
	
}
