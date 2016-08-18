package sjc.app.repository.dao.impl;

import org.springframework.stereotype.Repository;
import sjc.app.model.entity.ImageEntityImpl;
import sjc.app.repository.dao.ImageDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class ImageDaoImpl extends GenericDaoImpl<ImageEntityImpl> implements ImageDao
{
    public ImageDaoImpl()
    {
        super(ImageEntityImpl.class);
    }

    @Override
    public ImageEntityImpl findImageByUrl(String url)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ImageEntityImpl> c = cb.createQuery(ImageEntityImpl.class);
        Root<ImageEntityImpl> imageEntityRoot = c.from(ImageEntityImpl.class);
        Predicate condition = cb.equal(imageEntityRoot.get("url"), url);
        c.where(condition);
        TypedQuery<ImageEntityImpl> q = getEntityManager().createQuery(c);
        return q.getResultList().get(0);
    }
}
