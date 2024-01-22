package net.ausiasmarch.weekeat.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.ContentRepository;

@Service
public class ContentService {

    @Autowired
    ContentRepository oContentRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public ContentEntity get(Long id_content) {
        return oContentRepository.findById(id_content)
              .orElseThrow(() -> new ResourceNotFoundException("Content not found"));
    }

    public Long create(ContentEntity oContentEntity) {
        return oContentRepository.save(oContentEntity).getId_content();
    }

    public Page<ContentEntity> getPage(Pageable oPageable) {
        return oContentRepository.findAll(oPageable);
    }

    public Long delete(Long id_content) {
        oContentRepository.deleteById(id_content);
        return id_content;
    }

    @Transactional
    public Long empty() {
        oContentRepository.deleteAll();
        oContentRepository.resetAutoIncrement();
        oContentRepository.flush();
        return oContentRepository.count();
    }
}