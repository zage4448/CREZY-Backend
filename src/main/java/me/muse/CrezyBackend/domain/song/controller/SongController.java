package me.muse.CrezyBackend.domain.song.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.muse.CrezyBackend.domain.song.controller.form.SongModifyRequestForm;
import me.muse.CrezyBackend.domain.song.controller.form.SongRegisterRequestForm;
import me.muse.CrezyBackend.domain.song.entity.Song;
import me.muse.CrezyBackend.domain.song.service.SongService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import java.security.GeneralSecurityException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/song")
public class SongController {

    final private SongService songService;

    @PostMapping("/register") // 노래 등록
    public Long songRegister (@RequestBody SongRegisterRequestForm requestForm, @RequestHeader HttpHeaders headers) throws GeneralSecurityException, IOException {

        return songService.register(requestForm, headers);
    }

    @DeleteMapping("/{songId}") // 노래 삭제(하나만 삭제 -추후 다른 곳 이용)
    public boolean deleteSong(@PathVariable("songId") Long songId, @RequestHeader HttpHeaders headers) {
        log.info("deleteSong() ");
        return songService.delete(songId, headers);
    }
    @DeleteMapping("/delete-songIds") // 노래 여러개 삭제
    public boolean deleteSong(@RequestParam("songIds") List<Long> songIds, @RequestHeader HttpHeaders headers) {
        log.info("deleteSongIds() ");
        return songService.deleteSongIds(songIds, headers);
    }
    @PostMapping("/modify") // 노래 수정
    public boolean modifySong(@RequestBody SongModifyRequestForm requestForm, @RequestHeader HttpHeaders headers){
        log.info("modifySong() ");
        return songService.modify(requestForm, headers);
    }
}
