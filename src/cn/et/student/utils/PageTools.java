package cn.et.student.utils;

import java.util.List;

/**
 * ��ҳ����
 * @author Administrator
 * 2017��10��11��   ����3:35:55
 *  easytop samlinzhang 
 * PageTools.java
 */
public class PageTools {
    /**
     * �������
     * @param curPage  ҳ�洫��ĵ�ǰҳ
     * @param totalCount  ���ݿ��ѯ���ܼ�¼��
     * @param pageCount  ÿҳ��ʾ������
     */
   public PageTools(Integer curPage,Integer total,Integer pageCount){
       this.curPage=curPage;
       this.total=total;
       this.pageCount=pageCount==null?this.pageCount:pageCount;
       this.prePage=(curPage==1?1:curPage-1);
       this.totalPage=total%this.pageCount==0?total/this.pageCount:total/this.pageCount+1;
       this.nextPage=(curPage==totalPage)?totalPage:(curPage+1);
       this.startIndex=(curPage-1)*this.pageCount+1;
       this.endIndex=curPage*this.pageCount ; 
   }
   /**
    * ��ǰҳ����̬ ��ҳ�洫�ݵģ�
    */
   private Integer curPage;
   /**
    * ÿҳ��ʾ����
    */
   private Integer pageCount=10;
   /**
    * ��һҳ
    *  prePage=(curPage==1?1:curPage-1)
    *  ����
    *     2  --   1
    *     3  --   2
    *     1  --   1
    *  
    */
   private Integer prePage;
   /**
    * ��һҳ
    *  ������
    *  
    * nextPage=(curPage=totalPage)?totalPage:(curPage+1)
    *   curpage   totalPage  nextPage
    *     1         3          2
    *     2         3          3
    *     3         3          3 
    */
   private Integer nextPage;
   /**
    * ��ҳ��
    * pageCount(ÿҳ��ʾ������)    total(�ܼ�¼��)   totalPage
    *   10                        20           2
    *   10                        21           3
    * 
    * totalPage=total%pageCount==0?total/pageCount:total/pageCount+1
    * 
    */
   private Integer totalPage;
   /**
    * �ܼ�¼���������ݿ��ѯ��
    */
   private Integer total;
   /**
    * ��ʼ����
    * curPage  pageCount  start-end
    *  1          10       1-10
    *  2          10       11-20
    *                     (curPage-1)*pageCount+1   curPage*pageCount  
    */
   private Integer startIndex;
   /**
    * ��������
    */
   private Integer endIndex;
   
   
    /**
     * �洢���ղ�ѯ������
     */
   @SuppressWarnings("rawtypes")
private List rows;
   
   
   
    public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}

	/**
    * 2017��10��11��  Administrator
    * select * from ()
    * 
    * 
    * 
    **/
    public static void main(String[] args) {
        int curPage=3;
        int totalCount=26;
        int pageCount=5;
        PageTools pt=new PageTools(curPage, totalCount, pageCount);
        
        System.out.println(pt.getNextPage());
        System.out.println(pt.getPrePage());
        System.out.println(pt.getTotalPage());
        System.out.println(pt.getStartIndex());
        System.out.println(pt.getEndIndex());
        
    }
   
   
    
}
