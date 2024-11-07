/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/helper/GlobalLogicHelper.java.hbs
 */
package cn.ibizlab.plm.util.helper;

import org.springframework.data.domain.Page;
import java.util.List;

public class GlobalLogicHelper {


    public static void append(Object sourceParam, Object targetParam ,int nPos) throws Throwable {
        append(targetParam,nPos,sourceParam,0,0);
    }


    /**
     * 附加数据参数： 将源列表的指定元素附加到目标列表的指定位置
     * @param obj 附加对象
     * @param nPos 附加位置
     * @param paramObject 被附加对象
     * @param nSrcPos 附加对象位置
     * @param nSrcLength 附加对象长度
     * @throws Throwable
     */
    public static void append(Object obj ,int nPos, Object paramObject, int nSrcPos, int nSrcLength) throws Throwable {
        if (!(obj instanceof List)) {
            throw new RuntimeException(String.format("逻辑参数不是数据对象列表类型"));
        }

        List list = (List)obj;

        List srcList = asList(paramObject);
        if(srcList!=null) {
            int nLength = srcList.size();
            if(nSrcPos >= 0) {
                if(nSrcLength>0) {
                    if(nSrcPos + nSrcLength > nLength) {
                        throw new Exception("列表长度溢出");
                    }

                    nLength = nSrcPos + nSrcLength;
                }
            }

            int nInsertPos = nPos;
            if(nPos > list.size() ) {
                throw new Exception("插入位置溢出");
            }
            for(int i = nSrcPos; i< nLength; i++) {
                if(nInsertPos>=0) {
                    list.add(nInsertPos, srcList.get(i));
                    nInsertPos++;
                }
                else {
                    list.add(srcList.get(i));
                }
            }
        }
        else {
            if(nPos >=0) {
                if(nPos > list.size() ) {
                    throw new Exception("插入位置溢出");
                }
                list.add(nPos, paramObject);
            }
            else {
                list.add(paramObject);
            }
        }

        //throw new DataEntityRuntimeException(iDELogicRuntimeContext.getDataEntityRuntime(), iDELogicRuntimeContext.getDELogicRuntime(), String.format("逻辑参数[%1$s]未支持appendParamObject操作", getCodeName()));
    }

    /**
     * 将传入对象转化为列表对象
     * @param object
     * @return
     */
    public static List asList(Object object) {
        if(object instanceof List) {
            return (List)object;
        }

        if(object instanceof Page) {
            return ((Page)object).getContent();
        }

        return null;
    }

}