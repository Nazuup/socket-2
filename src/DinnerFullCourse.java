public class DinnerFullCourse {
    private Dish[] list = new Dish[5];// [0]-[4]の計5個

	public static void main(String[] args) {
		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}

    DinnerFullCourse(){
        for(int i = 0; i<list.length; i++){
            list[i] = new Dish();
        }
        list[0].setName("オムライス");
        list[0].setValune(1200);

        list[1].setName("カレーライス");
        list[1].setValune(900);

        list[2].setName("ステーキ");
        list[2].setValune(1300);

        list[3].setName("ナポリタン");
        list[3].setValune(800);

        list[4].setName("ケーキ");
        list[4].setValune(400);
    }
    void eatAll(){
        for(Dish dish : list){
            System.out.println("料理名：" + dish.getName());
            System.out.println("値段" + dish.getValune());
            System.out.println();
        }
    }
}
