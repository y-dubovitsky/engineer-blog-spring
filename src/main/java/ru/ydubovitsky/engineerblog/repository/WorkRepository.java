package ru.ydubovitsky.engineerblog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.ydubovitsky.engineerblog.entity.Work;

public interface WorkRepository extends PagingAndSortingRepository<Work, Integer> {

}
