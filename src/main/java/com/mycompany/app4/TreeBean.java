package com.mycompany.app4;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;

@Named("treeBean")
@ViewScoped
public class TreeBean implements Serializable {

    private TreeNode root;
    private TreeNode singleSelectedTreeNode;
    private boolean renderPdfViewer;
    private String pdfViewerUrl;
    private boolean renderGraphicImage;
    private String graphicImageUrl;
    private HashMap<String,String> map;
    private boolean renderIframe;
    private String iframeUrl;
    
    /*
    @Inject
    FacesContext context;
    
    @Inject
    PrimeFaces primeFaces;
    */
    
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSingleSelectedTreeNode() {
        return singleSelectedTreeNode;
    }

    public boolean isRenderPdfViewer() {
        return renderPdfViewer;
    }

    public void setRenderPdfViewer(boolean renderPdfViewer) {
        System.out.println("setRenderPdfViewer: " + renderPdfViewer);
        this.renderPdfViewer = renderPdfViewer;
    }

    public String getPdfViewerUrl() {
        return pdfViewerUrl;
    }

    public void setPdfViewerUrl(String PdfViewerUrl) {
        this.pdfViewerUrl = PdfViewerUrl;
    }

    public boolean isRenderGraphicImage() {
        return renderGraphicImage;
    }

    public void setRenderGraphicImage(boolean renderGraphicImage) {
        System.out.println("setRenderGraphicImage: " + renderGraphicImage);
        this.renderGraphicImage = renderGraphicImage;
    }

    public String getGraphicImageUrl() {
        return graphicImageUrl;
    }

    public void setGraphicImageUrl(String graphicImageUrl) {
        this.graphicImageUrl = graphicImageUrl;
    }

    public boolean isRenderIframe() {
        return renderIframe;
    }

    public void setRenderIframe(boolean renderIframe) {
        this.renderIframe = renderIframe;
    }

    public String getIframeUrl() {
        return iframeUrl;
    }

    public void setIframeUrl(String iframeUrl) {
        this.iframeUrl = iframeUrl;
    }

    public void setSingleSelectedTreeNode(TreeNode singleSelectedTreeNode) {
        if(singleSelectedTreeNode!=null) {
            System.out.println("setSingleSelectedTreeNode: " + singleSelectedTreeNode.getData().toString());
            setRenderPdfViewer(false);
            setRenderGraphicImage(false);
            setRenderIframe(false);
            //setGraphicImageUrl("");
            //setPdfViewerUrl("");
            TreeMenuItem i = (TreeMenuItem) singleSelectedTreeNode.getData();
            if(i.getFileExtension().toLowerCase().endsWith("pdf")) {
                System.out.println("is a pdf");
                setPdfViewerUrl(this.map.get(i.getDocumentId()));
                System.out.println(getPdfViewerUrl());
                setRenderPdfViewer(true);
            } else if(i.getFileExtension().toLowerCase().endsWith("jpg")) {
                System.out.println("is a jpg");
                setGraphicImageUrl(this.map.get(i.getDocumentId()));
                System.out.println(getGraphicImageUrl());
                setRenderGraphicImage(true);
            } else if(i.getFileExtension().toLowerCase().endsWith("png")) {
                System.out.println("is a png");
                setGraphicImageUrl(this.map.get(i.getDocumentId()));
                System.out.println(getGraphicImageUrl());
                setRenderGraphicImage(true);
            } else if(i.getFileExtension().toLowerCase().endsWith("txt")) {
                System.out.println("is a txt");
                setIframeUrl(this.map.get(i.getDocumentId()));
                System.out.println(getPdfViewerUrl());
                setRenderIframe(true);
            } else if(i.getFileExtension().toLowerCase().endsWith("docx")) {
                System.out.println("is a docx");
                setIframeUrl(this.map.get(i.getDocumentId()));
                System.out.println(this.map.get(i.getDocumentId()));
                // browser should download file
                setRenderIframe(true);
            }
            /*
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            //externalContext.
            RequestContext.getCurrentInstance().update("editorForm:dropArea");
            */
            //context.getCurrentPhaseId()
            //PrimeFaces.current().ajax().update(":frm1:aa :frm1:bb");
            PrimeFaces.current().ajax().update("aa bb cc");
            //InputStream input = new URL("http://www.somewebsite.com/a.txt").openStream();
            //StreamedContent dbImage = new DefaultStreamedContent(input, "image/jpeg");
        }
        this.singleSelectedTreeNode = singleSelectedTreeNode;
    }
    
    @PostConstruct
    public void getTree() {
        
        this.map=new HashMap<String, String>();
        /*
        //this.map.put("1", "https://www.mathworks.com/content/dam/mathworks/mathworks-dot-com/moler/random.pdf");
        this.map.put("1", "https://filesamples.com/samples/document/pdf/sample3.pdf");
        this.map.put("2", "https://www.computerhope.com/jargon/j/jpg.jpg");
        this.map.put("3", "https://cdn0.iconfinder.com/data/icons/document-file-types/512/png-512.png");
        */
        
        this.map.put("1", "http://localhost:8080/app4-1.0-SNAPSHOT/api/v1/document/pdf-stream4/1/abc");
        this.map.put("2", "http://localhost:8080/app4-1.0-SNAPSHOT/api/v1/document/jpg/2/abc");
        this.map.put("3", "http://localhost:8080/app4-1.0-SNAPSHOT/api/v1/document/png/3/abc");
        this.map.put("4", "http://localhost:8080/app4-1.0-SNAPSHOT/api/v1/document/text/4/abc");
        this.map.put("5", "http://localhost:8080/app4-1.0-SNAPSHOT/api/v1/document/docx/5/abc");
        
        
        //setGraphicImageUrl(this.map.get("a.jpg"));
        setGraphicImageUrl(null);
        //setRenderGraphicImage(true);
        //setGraphicImageUrl("");
        setRenderGraphicImage(false);
        
        //setPdfViewerUrl(this.map.get("a.pdf"));
        setPdfViewerUrl(null);
        setRenderPdfViewer(false);
        setRenderIframe(false);
        
        root = new DefaultTreeNode("root", null);
        TreeNode cdsFolderAll = new DefaultTreeNode("All", this.root);
        /*
        TreeNode cdsFolderAll_aPDF = new DefaultTreeNode("document", "a.pdf", cdsFolderAll);
        TreeNode cdsFolderAll_aJPG = new DefaultTreeNode("document", "a.jpg", cdsFolderAll);
        TreeNode cdsFolderAll_aPNG = new DefaultTreeNode("document", "a.png", cdsFolderAll);
        */
        TreeNode cdsFolderAll_aPDF = new DefaultTreeNode("document", new TreeMenuItem("01/01/2022 pdf", "1", "pdf"), cdsFolderAll);
        TreeNode cdsFolderAll_aJPG = new DefaultTreeNode("document", new TreeMenuItem("02/01/2022 jpg", "2", "jpg"), cdsFolderAll);
        TreeNode cdsFolderAll_aPNG = new DefaultTreeNode("document", new TreeMenuItem("03/01/2022 png", "3", "png"), cdsFolderAll);
        TreeNode cdsFolderAll_aTXT = new DefaultTreeNode("document", new TreeMenuItem("04/01/2022 txt", "4", "txt"), cdsFolderAll);
        TreeNode cdsFolderAll_aDOCX = new DefaultTreeNode("document", new TreeMenuItem("05/01/2022 docx", "5", "docx"), cdsFolderAll);
        
        //root.addChild(new DefaultTreeNode("document", "a.png", cdsFolderAll));
    }
    
    public void onNodeSelect(NodeSelectEvent event) {
        String node = event.getTreeNode().getData().toString();
        System.out.println(node);
    }
    
    public void onNodeUnselect(NodeUnselectEvent event) {
        String node = event.getTreeNode().getData().toString();
        System.out.println(node);
    }

    public void onNodeExpand(NodeExpandEvent event) {
        String node = event.getTreeNode().getData().toString();
        System.out.println(node);
    }

    public void onNodeCollapse(NodeCollapseEvent event) {
        String node = event.getTreeNode().getData().toString();
        System.out.println(node);
    }

}
