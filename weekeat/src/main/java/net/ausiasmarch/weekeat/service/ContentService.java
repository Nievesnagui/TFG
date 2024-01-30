package net.ausiasmarch.weekeat.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.api.dto.ContentDTO;
import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.repository.ContentRepository;

@Service
public class ContentService {

    @Autowired
    ContentRepository oContentRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public ContentDTO get(Long id) {
        var content = oContentRepository.findById(id).orElse(new ContentEntity());
        return new ContentDTO(content.getId(),content.getId_ingredient(), content.getId_recipe());
    }

    public Long create(ContentEntity oContentEntity) {
        return oContentRepository.save(oContentEntity).getId();
    }

    public Page<ContentEntity> getPage(Pageable oPageable) {
        return oContentRepository.findAll(oPageable);
    }

    public Long delete(Long id) {
        oContentRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long empty() {
        oContentRepository.deleteAll();
        oContentRepository.resetAutoIncrement();
        oContentRepository.flush();
        return oContentRepository.count();
    }
}