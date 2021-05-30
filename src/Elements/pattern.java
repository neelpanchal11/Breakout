package Elements;

public class pattern {
	
	boolean pat [][][] = {
			
			{	//Demo
				{false, false , false , false, false, false, false, false, false},
				{false, false , false , false, false, false, false, false, false},
				{false, false , false , false, false, false, false, false, false},
				{false, false , false , false, false, false, false, false, false},
				{true, false , false , true, false, false, false, false, false},
				{false, false , false , false, false, false, false, false, false}
			},
			
			{	//Level1
				{true, true , true , true, true, true , true, true, true},
				{false, true , true , false, false, true, true, false, true},
				{true, true, true, false, false, true, true , true, true},
				{true, true , true, true, true, true, true, true, true},
				{false, false, true , true, true, true, false ,false, true},
				{false, false, true , true, true, true, false ,false, true}
			},	
			
			{	//Level2
				{true , true , true,  true,  true , true,  true,  true , true},
				{true , false, false, false, false, false, false, false, true},
				{true , true,  true,  true,  true,  true , true , true , true},
				{true , false, false, true,  true,  true,  false, false, true},
				{true , false, false, false, true,  false, false, false, true},
				{true , false, false, false, true,  false, false, false, true}
			},
	
			{	//Level3
				{false,  false , false , true,  true,  true,  false, false, false},
				{true,  false , true ,  true,  false, true,  true,  false, true},
				{true,  true ,  true ,  false, false, false, true,  true,  true},
				{true,  true ,  false , false, false, false, false, true,  true},
				{true,  false , true ,  false, false, false, true,  false, true},
				{false,  false , false , true,  true,  true,  false, false, false}
			},
			
			{	//Level4
				{true,  true , true , true,  true,  true,  true,  true, true},
				{true,  true , true , true,  false, true,  true,  true, true},
				{true,  true , true , false, true,  false, true,  true, true},
				{true,  true , false, true,  true,  true,  false, true, true},
				{true,  false ,false, true,  true,  true,  false, true, true},
				{true,  false ,false, false, true,  false, false, true, true}
			},	
			
			{	//Level5
				{false,  false , false , false, false, false,  false, false,  false},
				{false,  true ,  true ,  false, false, false,  true,  true,  false},
				{false,  false , true ,  true,  true,  true,   true,  false, false},
				{false,  false , false,  true,  true,  true,   false, false, false},
				{false,  false , false,  false, true,  false,  false, false, false},
				{false,  true ,  true,   true,  true,  true,   true,  true,  false}
			},
			
			{	//Level6
				{false,  false , false,  false, false, false, false, false, false},
				{false,  false , false , true , true,  true,  false, false, false},
				{true ,  false , true ,  false, true,  false, true,  false, true },
				{true ,  false , true ,  true , true,  true,  true,  false, true },
				{false,  false , true ,  false, true,  false, true,  false, false},
				{true ,  false , false,  true , true,  true,  false, false, true },
			},
			
			{	//Level7
				{false,  false , false , false, false, false,  false, false, true },
				{false,  true ,  false,  false, false, false,  false,  true, false},
				{false,  false , true ,  true,  true,  true,   true,  false, false},
				{false,  true  , false,  true,  true,  true,   false, true , false},
				{false,  false , false,  false, true,  false,  false, false, false},
				{false,  true ,  true,   false,  true, false,  true,  true,  false}
			},
			
			{	//Level8
				{false,  false , false , false, false, false,  false, false, false},
				{false,  true ,  true ,  false, false, false,  true,  true,  false},
				{false,  false , true ,  true,  true,  true,   true,  false, false},
				{false,  false , false,  true,  true,  true,   false, false, false},
				{false,  false , false,  false, true,  false,  false, false, false},
				{false,  true ,  true,   true,  true,  true,   true,  true,  false}
			},
			
			{	//Level9
				{false,  false , false , false, false, false,  false, false, false},
				{false,  true ,  true ,  false, false, false,  true,  true,  false},
				{false,  false , true ,  true,  true,  true,   true,  false, false},
				{false,  false , false,  true,  true,  true,   false, false, false},
				{false,  false , false,  false, true,  false,  false, false, false},
				{false,  true ,  true,   true,  true,  true,   true,  true,  false}
			}
	};

}
