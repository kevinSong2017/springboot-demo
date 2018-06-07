package com.demo.controller.controllerImpl;


import com.demo.entity.Imageinfo;

import java.util.List;
import java.util.concurrent.*;

public class Renderer {

    private ExecutorService executor ;

    public Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source){

        List<Imageinfo> info=scanForImageInfo(source);

        CompletionService<Imageinfo> completionService=new ExecutorCompletionService<Imageinfo>(executor);

        for (final Imageinfo imageinfo:info){
            Future<Imageinfo> result = completionService.submit(new Callable<Imageinfo>() {
                @Override
                public Imageinfo call() throws Exception {
                    return imageinfo.downLoadImage();
                }
            });

        }
        renderText(source);

        for (int i=0;i<info.size();i++){
            try {
                Future<Imageinfo> future = completionService.take();
                Imageinfo imageinfo = future.get();
                renderImage(imageinfo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }



    }

    /**
     * 渲染图片
     * @param imageinfo
     */
    private void renderImage(Imageinfo imageinfo) {
        System.out.println("渲染图片");
    }


    private void renderText(CharSequence source) {
        System.out.println("渲染文字");
    }

    /**
     * 扫描图片
     * @param source
     * @return
     */
    public List<Imageinfo> scanForImageInfo(CharSequence source) {
        return null ;
    }





}
