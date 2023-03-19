package com.rouvsen.security.jwt;

import org.springframework.data.repository.CrudRepository;

//JpaRepository-nin CrudRepository-den elave olan ozelliyi ==> 'Paging'

public interface _03_UserRepository extends CrudRepository<_02_UserEntity, Long> {
    _02_UserEntity findByUsername(String username);
}
