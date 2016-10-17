import java.util.ArrayList;
import java.util.Arrays;


public class program2 implements Comp{

	@Override
	public int calc(int[] val, ArrayList<GenerateType> GenerateType_list, ArrayList<Integer> num_list) {
		int num1 = 3;
		boolean[] result = new boolean[val.length];
		for(int i = 0; i < val.length; i++){
			result[i] = (Tool.compare(val[i], num_list.get(i), GenerateType_list.get(i)));
		}
		
		if(result[0] && result[1] && result[2]){
			if(result[3]){
				num1 = num1 +3;
			}else{
				num1 -= 2;
			}
		}else{
			if(result[4]){
				num1 +=5;
			}else{
				num1 -=6;
			}
		}
		if(result[5] || result[6]){
			num1 += 4;
		}else{
			if(result[7]){
				num1 +=1;
			}else{
				num1 *= 2;
			}
		}
		if(result[8] && result[9]  || result[10] &&result[11]){
			num1 += 11;
		}else{
			if(result[12]|| result[13]){
				num1 += 5;
			}else{
				if(result[14]|| result[15]  && result[16]){
					num1 -= 6;
				}else{
					num1 *= 2;
				}
			}
		}
		
		if(result[17] || result[18]){
			num1 = num1 *2;
		}else{
			num1 = num1 - 2;
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
		boolean[][] node891011_true = Tool.getArrayByAndOrAnd_RANDOM_ONE(TRUE);
		boolean[][] node891011_false = Tool.getArrayByAndOrAnd_RANDOM_ONE(FALSE);
		
		boolean[][] node1213_true = Tool.getArrayByOr_RANDOM_ONE(TRUE);
		boolean[][] node1213_false = Tool.getArrayByOr_RANDOM_ONE(FALSE);
		
		boolean[][] node141516_true = Tool.getArrayByAndOR_RANDOM_ONE(TRUE);
		boolean[][] node141516_false = Tool.getArrayByAndOR_RANDOM_ONE(FALSE);
		boolean[][] node141516_all = Tool.getArrayByAndOR_RANDOM_ONE(ALL);
		
		boolean[][] part3_1 = Tool.Cross_Join(new boolean[][][]{node891011_true,empty_len2,empty_len3});
	
		
		boolean[][] node1213141516_total = Tool.Add(
				Tool.Cross_Join(node1213_true, empty_len3), 
				Tool.Cross_Join(node1213_false,node141516_all));
		
		
		boolean[][] part3 = Tool.Add(
				part3_1,
				Tool.Connect (
						node891011_false,
						node1213141516_total
						)
				);
		boolean[][] part4 = Tool.getArrayByOr(ALL);
		boolean[][] path_Testcase = Tool.Cross_Join(new boolean[][][] {part1, part2, part3,part4});
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
		
		boolean[][] node891011_true = Tool.getArrayByAndOrAnd(TRUE);
		boolean[][] node891011_false = Tool.getArrayByAndOrAnd(FALSE);
		
		boolean[][] node1213_true = Tool.getArrayByOr(TRUE);
		boolean[][] node1213_false = Tool.getArrayByOr(FALSE);
		
		
		boolean[][] node141516_true = Tool.getArrayByAndOR(TRUE);
		boolean[][] node141516_false = Tool.getArrayByAndOR(FALSE);
		boolean[][] node141516_all = Tool.getArrayByAndOR(ALL);
//		System.out.println(node891011_true.length);
//		System.out.println(node891011_false.length);
		
		boolean[][] part3_1 = Tool.Connect(new boolean[][][]{node891011_true,empty_len2,empty_len3});
	
		
		boolean[][] node1213141516_total = Tool.Add(
				Tool.Connect(node1213_true, empty_len3), 
				Tool.Connect(node1213_false,node141516_all));
		

		boolean[][] tmp =Tool.Connect (
				node891011_false,
				node1213141516_total
				);
		
		boolean[][] part3 = Tool.Add(
				part3_1,
				tmp
				);
		
		boolean[][] part4 = Tool.getArrayByOr(ALL);
		
		
//		System.out.println(part3_1.length);
//		System.out.println(tmp.length);
//		System.out.println(part3.length);
		
		boolean[][] path_Testcase = Tool.Connect(new boolean[][][] {part1, part2, part3, part4});
		
		int arr[][] = Tool.generate_test_num_list_array(GenerateType_list,num_list,path_Testcase);
//		System.out.println(arr.length);
		return arr;
	}

	public static void main(String[] args) {
		    boolean printDetail = false;
		    int freq = 20;
			//right program
			ArrayList<Integer> num_list = new ArrayList<Integer>(); 
			ArrayList<GenerateType> GenerateType_list = new ArrayList<GenerateType>(); 
			int arr[] = {1,2,3,7,9,3,2,1,1,4,4,2,3,4,9,3,2,1,2};
			for(int val: arr){
				num_list.add(val);
			}
			
			//set up type; 
			GenerateType gt_arr[] = 
				{GenerateType.LARGE,GenerateType.LARGE,GenerateType.EQUAL,GenerateType.LESS,
						GenerateType.LESS,GenerateType.LARGE,GenerateType.LARGE,GenerateType.LESS_EQUAL,
						GenerateType.LESS_EQUAL,GenerateType.LESS_EQUAL,GenerateType.LARGE_EQUEAL,GenerateType.LESS,
						GenerateType.LARGE,GenerateType.LARGE,GenerateType.LESS_EQUAL,GenerateType.LESS,GenerateType.LESS_EQUAL,
						GenerateType.LESS,GenerateType.LESS_EQUAL	
				};
			for(GenerateType t : gt_arr){
				GenerateType_list.add(t);
			}
			
			//seeded program

			ArrayList<Integer> num_list_1 = new ArrayList<Integer>(); 
			ArrayList<GenerateType> GenerateType_list_1 = new ArrayList<GenerateType>(); 
			int arr_1[] = {1,2,3,7,9,3,2,1,1,4,4,2,3,4,9,3,2,1,2};
			// no4 9 no8 5
			for(int val: arr_1){
				num_list_1.add(val);
			}
			
			//set up type; 
			GenerateType gt_arr_1[] = 
				
				{GenerateType.LARGE,GenerateType.LARGE,GenerateType.EQUAL,GenerateType.LESS,
						GenerateType.LESS,GenerateType.LARGE,GenerateType.LARGE,GenerateType.LESS_EQUAL,
						GenerateType.LESS_EQUAL,GenerateType.LESS_EQUAL,GenerateType.LARGE_EQUEAL,GenerateType.LESS,
						GenerateType.LARGE,GenerateType.LARGE,GenerateType.LESS_EQUAL,GenerateType.LESS,GenerateType.LESS_EQUAL,
						GenerateType.LESS,GenerateType.LESS_EQUAL
				};
			for(GenerateType t : gt_arr_1){
				GenerateType_list_1.add(t);
			}
			
			
			program2 example = new program2();
			program2_bug example_bug = new program2_bug();
			System.out.println("PathCoverage");
			// example1
			
			int [][] tmp = example.generatePathCoverage(GenerateType_list, num_list);
			int[][] res = tmp;
			for(int i = 0; i < 100; i+=freq){
				double del_percent = (double)i /100;
				double coverage = (double)(100-i)/100;
//				System.out.println("coverage:"+ coverage*100+"%");
//				res = Tool.DelTestCase(res, (int)(0.1* tmp.length));
				int[] result = example.calc_arr(res, GenerateType_list,num_list);
//				System.out.println("Length of test case:"+result.length);
				if(printDetail)
				System.out.println(Arrays.toString(result));
				
				int[] result_bug = example_bug.calc_arr(res, GenerateType_list_1,num_list_1);
				if(printDetail)
				System.out.println(Arrays.toString(result_bug));
				
				int[][]diff = Tool.compare_arr(result, result_bug, res);
				System.out.println("Length of different/ Length of test case:"+diff.length+"/"+res.length);
				
				if(printDetail)
				Tool.printIntArray(diff);
				
				int found_fault = example.checkBug(diff,GenerateType_list,num_list);
				System.out.println("found_fault:"+found_fault);
				System.out.println();
//				System.out.println((double)freq/100 *  tmp.length);
				res = Tool.DelTestCase(res, (int)Math.ceil(((double)freq/100* tmp.length)));
			}
			
			System.out.println("MultiCoverage");
			// example1
			
			int [][] tmp_ = example.generateMultiCoverage(GenerateType_list, num_list);
			
			int[][] res_ = tmp_;
			for(int i = 0; i < 100; i+=freq){
				double del_percent = (double)i /100;
				double coverage = (double)(100-i)/100;
//				System.out.println("coverage:"+ coverage*100+"%");
//				res_ = Tool.DelTestCase(res_, (int)(0.1* tmp_.length));
				int[] result = example.calc_arr(res_, GenerateType_list,num_list);
//				System.out.println("Length of test case:"+result.length);
				if(printDetail)
				System.out.println(Arrays.toString(result));
				
				int[] result_bug = example_bug.calc_arr(res_, GenerateType_list_1,num_list_1);
				if(printDetail)
				System.out.println(Arrays.toString(result_bug));
				
				int[][]diff = Tool.compare_arr(result, result_bug, res_);
//				System.out.println("Length of different/ Length of test case:"+diff.length+"/"+res_.length);
				
				if(printDetail)
				Tool.printIntArray(diff);
				
				int found_fault = example.checkBug(diff,GenerateType_list,num_list);
				System.out.println("found_fault:"+found_fault);
				System.out.println();

				res_ = Tool.DelTestCase(res_, (int)Math.ceil(((double)freq/100* tmp_.length)));

			}
			
		
			
			
	}

	@Override
	public int checkBug(int[][] arr, ArrayList<GenerateType> GenerateType_list, ArrayList<Integer> num_list) {
		
		int bugs[] = {0,0,0,0,0};
		
		for(int i = 0 ; i < arr.length; i++){
			int bug[] = {0,0,0,0,0};
//			System.out.println(arr[i].length);

			boolean[] result = new boolean[arr[i].length];
			for(int j = 0; j < arr[i].length; j++){
				result[j] = (Tool.compare(arr[i][j], num_list.get(j), GenerateType_list.get(j)));
//				result[j] = false;
			}
			boolean error13 = Tool.compare(arr[i][13], 1, GenerateType_list.get(16));
			
//			System.out.println(result[5] + ".."+result[6]);
//			System.out.println(Arrays.toString(result));
			if((result[8] && result[9]  || result[10] &&result[11] ) == false 
					&&((result[12] && result[13]) == false) 
					&& (result[14]|| result[15]  && result[16]) == false
							){
				bug[0] = 1;
				bugs[0] = 1;
			}
			if(result[0] ==true && result[1] == true && result[2] == false ){
				bug[1] = 1;
				bugs[1] = 1;
			}
			if(result[7] == false){
				bug[2] = 1;
				bugs[2] = 1;
			}
			if(result[17] == false && result[18] == true || result[18] == true && result[17] == false){
				bug[3] = 1;
				bugs[3] = 1;
			}
			if((result[5] || result[6]) == false&& result[7] == false){
				bug[4] = 1;
				bugs[4] = 1;
			}
//			System.out.println(i+":"+Arrays.toString(bug));
		}
		int count = 0;
		for(int l = 0; l < 5; l++){
			if(bugs[l] == 1){
				count++;
			}
		}
		return count;
//		return 0;

		
		
	}
	
	
}
