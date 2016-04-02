package vn.chuonghd.connectionpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.chuonghd.connectionpool.domain.User;

/**
 * Created by huynhduychuong on 4/1/2016.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
