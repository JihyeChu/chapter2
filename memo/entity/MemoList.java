package chapter2.memo.entity;

import chapter2.memo.ui.Home;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MemoList {
    private int count;
    private LinkedList<Memo> list;
    private StringBuffer sb;
    private Scanner sc;

    public MemoList() {
        count = 0;
        this.list = new LinkedList<>();
        sc = new Scanner(System.in);
    }

    // 메모 전체 조회 - Getter
    public LinkedList<Memo> getMemoList() {
        return list;
    }

    // 메모 전체 조회 - Setter
    public void setMemoList(LinkedList<Memo> memoList) {
        this.list = memoList;
    }

    // 작성 최신순 메모 출력 (구현)
    public void printMemoList() {
        // 기존 list를 for문을 통해 접근해 출력하기
        sb = new StringBuffer();
        for(Memo memo : list){
            sb.append(String.format("%d. %s | %s | %s\n", memo.getNum(), memo.getName(), memo.getPost(), memo.dateFormat(Calendar.getInstance())));
        }
//        for(int i=0; i<list.size(); i++){
//            sb.append(String.format("%d. %s | %s | %s\n", list.get(i).getNum(), list.get(i).getName(), list.get(i).getPost(),
//                                    list.get(i).dateFormat(Calendar.getInstance()) ));
//        }
        System.out.println(sb);
    }

    // 메모 1건 추가 (구현)
    public void addMemo(Memo memo){
        // 기존 list에 Memo 추가
       list.add(memo);
    }

    // 글 수정/삭제 시, 글 번호를 받아서 해당 메모를 반환 (구현)
    public Memo getMemo(int idx) {
        // list에서 idx에 해당하는 Memo 반환하기
        return null;
    }

    // 메모 1건 수정 (구현)
    public void editMemo(int idx) {
        sc = new Scanner(System.in);
        // list에서 idx에 해당하는 Memo 가져오기
        System.out.println("수정할 내용: " + list.get(idx).getName());
        // 해당 Memo의 게시글(post) 필드 갱신
        System.out.println("수정할 내용을 입력하세요.");
        String post = sc.nextLine();
        list.set(idx, new Memo(idx+1, list.get(idx).getName(),list.get(idx).getPassword(), post));
        System.out.println( String.format("%d. %s | %s | %s\n", list.get(idx).getNum(),list.get(idx).getName(), list.get(idx).getPost(),
                list.get(idx).dateFormat(Calendar.getInstance())));

    }

    // 메모 1건 삭제 (구현)
    public void deleteMemo(int idx) {
        // list에서 idx에 해당하는 Memo 가져오기
        System.out.println("삭제할 내용: " + String.format("%d. %s | %s | %s\n", list.get(idx).getNum(),list.get(idx).getName(), list.get(idx).getPost(),
                list.get(idx).dateFormat(Calendar.getInstance())));
        // list에서 해당 memo를 제거
        list.remove(idx);
        // 글 삭제 후 글 번호 재지정 작업
        editMemoNum();
        // count 수정
        minusCount();
    }

    // 글 삭제 후 Memo의 num 필드 수정 (구현)
    public void editMemoNum(){
        for(int i=0; i<list.size(); i++){
            list.set(i, new Memo(i+1, list.get(i).getName(),list.get(i).getPassword(), list.get(i).getPost()));
        }
    }

    public int getCount() {
        ++count;
        return count;
    }

    // 글 삭제 후 count 값 수정
    public void minusCount(){

        --count;
    }
}
