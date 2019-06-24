package com.whb.service;

import com.whb.dao.LabelRepository;
import com.whb.entity.Label;
import com.whb.util.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LabelService {
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private IdWorker idWorker;

    public void add(Label label) {
        label.setId(idWorker.nextId() + "");
        labelRepository.save(label);
    }

    public List<Label> list() {
        return labelRepository.findAll();
    }

    public List<Label> topList() {
        return labelRepository.findByRecommend("是");
    }

    public void update(Label label) {
        labelRepository.save(label);
    }

    public void delete(String id) {
        labelRepository.deleteById(id);
    }

    public Label findById(String id) {
        return labelRepository.findById(id).get();
    }

    public List<Label> search(Label label) {
        return labelRepository.findAll(getPredicate(label));
    }

    public Page<Label> searchPage(Label label, int page, int size) {
        PageRequest of = PageRequest.of(page - 1, size);
        return labelRepository.findAll(getPredicate(label), of);
    }

    private Specification<Label> getPredicate(Label label) {
        return (Specification<Label>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (StringUtils.isNoneBlank(label.getLabelname())) {
                list.add(criteriaBuilder.like(root.get("labelname"), "%" + label.getLabelname() + "%"));
            }
            if (StringUtils.isNoneBlank(label.getState())) {
                list.add(criteriaBuilder.equal(root.get("state"), label.getState()));
            }
            if (StringUtils.isNoneBlank(label.getRecommend())) {
                list.add(criteriaBuilder.equal(root.get("recommend"), label.getRecommend()));
            }
            return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
        };
    }
}
