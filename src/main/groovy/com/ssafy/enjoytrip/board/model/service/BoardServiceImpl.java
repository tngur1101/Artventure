package com.ssafy.enjoytrip.board.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;
    static final String FOLDER = "/src/main/resources/static/image/";
    static final String DOMAIN = "http://localhost:80/image/";
//    @Override
//    public void writeArticle(BoardDto boardDto) {
//        boardMapper.writeArticle(boardDto);
//
//        //이미지 파일 등록하는 부분 -> 추후 프론트 생성 후 확인 필요!
//        List<FileInfoDto> fileInfos = boardDto.getFileInfos();
//        if(fileInfos != null && !fileInfos.isEmpty()){
//            boardMapper.registerFile(boardDto);
//        }
//    }
@Override
public void writeArticle(BoardDto boardDto) {
//    boardMapper.writeArticle(boardDto);
    boardMapper.writeArticle(boardDto);
    // Todo: select key로 boadid 매핑
    //이미지 파일 등록하는 부분 -> 추후 프론트 생성 후 확인 필요!
//    List<FileInfoDto> fileInfos = boardDto.getFileInfos();
//    List<FileInfoDto> fileInfos = map.getFileInfos();
//    if(fileInfos != null && !fileInfos.isEmpty()){
//        boardMapper.registerFile(boardDto);
//    }
//    if(fileInfos != null && !fileInfos.isEmpty()){
//        boardMapper.registerFile(map);
//    }
//    if(boardDto.getFiles()!=null && boardDto.getFiles().length!=0){
//        boardMapper.registerFile(boardDto);
//    }
}

    @Override
    public void saveImage(MultipartFile[] file, BoardDto boardDto) throws Exception{

        System.out.println("saveImage 함수 들어옴");
        System.out.println("Service에서 BoardDto"+boardDto);

        String pathDefault = System.getProperty("user.dir").replace('\\', '/');
        String folder = pathDefault+FOLDER;

        for(MultipartFile f: file){
            String originalFileName = f.getOriginalFilename();
            if(originalFileName==null || originalFileName.equals("")) continue;
            String uploadFileName = UUID.randomUUID()+"_"+originalFileName;

            Map<String, Object> map= new HashMap<>();

            String uploadFilePath = folder+uploadFileName;  //  DB와 연관 없음
            Path savePath = Paths.get(uploadFilePath);
            System.out.println("savePath:"+savePath);
            System.out.println("savePath string값: "+String.valueOf(savePath));
            String url = DOMAIN+uploadFileName;
            //  locahost:80/image/image.png =>saveFolder곳에 넣어버리고 얘만 꺼내서 쓰자

            // Todo: 경로 매핑
            System.out.println(url);

            map.put("articleNo", boardDto.getArticleNo());
            map.put("imageUrl", url);

            boardMapper.registerFile(map);
            f.transferTo(savePath); // 실제 파일에 저장
        }


        //1. FileInfos 만들기
        //2. boardMapper.registerFile하는 것
        //3. File 서버에 저장

    }


    @Override
    public BoardListDto listArticle(Map<String, String> map) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("type", map.get("type")==null?"":map.get("type"));
        param.put("word", map.get("word")==null?"":map.get("word"));
        param.put("regionId", map.get("regionid") == null ? "" : map.get("regionid"));
        int currentPage = Integer.parseInt(map.get("pgno")==null?"1":map.get("pgno"));
        int sizePerPage = Integer.parseInt(map.get("spp")==null?"10":map.get("spp"));

        int start = currentPage*sizePerPage-sizePerPage;

        param.put("start", start);
        param.put("spp", sizePerPage);

        String key = map.get("key");
        param.put("key", key==null?"":key);

        System.out.println("param : "+param);
        List<BoardDto> list = boardMapper.listArticle(param);
        int totalArticleCount = boardMapper.getTotalArticleCount(param);
        int totalPageCount = (totalArticleCount-1)/sizePerPage+1;

        BoardListDto boardListDto = new BoardListDto();
        boardListDto.setArticles(list);
        boardListDto.setCurrentPage(currentPage);
        boardListDto.setTotalPageCount(totalPageCount);

        return boardListDto;
    }

    @Override
    public BoardDto selectByArticleNo(int articleNo) {
        return boardMapper.selectByArticleNo(articleNo);
    }

    @Override
    public void deleteArticle(int articleNo) {
        boardMapper.deleteArticle(articleNo);
    }

    @Override
    public void updateArticle(BoardDto boardDto) {
        boardMapper.updateArticle(boardDto);
    }


}
