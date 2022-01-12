package ru.ydubovitsky.employeefinder.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.ydubovitsky.employeefinder.entity.Work;

public interface WorkRepository extends PagingAndSortingRepository<Work, Integer> {

}
