package com.example.jesophwen.josephwenandroidtext.FragmentFiles;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jesophwen.josephwenandroidtext.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenkui on 16/9/26.
 */

public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView listView;  // 新闻列表视图
    List<News> newsList;    // 新闻数据集合
    NewsListAdapter adapter;   // 新闻列表适配器
    boolean isTwoPage;  // 是否是双页显示

    /** 设置新闻列表内容 */
    public List<News> initNews() {
        List<News> newses = new ArrayList<News>();
        News news1 = new News("李克强同古巴国务委员会主席兼部长会议主席劳尔·卡斯特罗举行会谈", " 李克强首先转达习近平主席对劳尔·卡斯特罗主席的亲切问候。李克强表示，中古建交56年来，两国关系不断取得新的发展。中国坚持中古友好的方针不变，支持古巴走社会主义道路的决心不变，推动中古务实合作的方向不变。新形势下，中方愿同古方密切高层往来，深化务实合作，加强在国际事务中的沟通协调，促进中古关系持续向前发展。\n" +
                "　　 李克强指出，当前中古都面临发展经济、改善民生的紧迫任务。中方愿同古方聚焦发展合作，支持古工业化进程，开展基础设施等建设规划和工业装备制造业合作;扩大贸易往来和投融资合作;分享发展经验，开展智力合作;拓展人文交流，加强青年人才培养，让中古友谊在发展中世代传承。\n" +
                "　　 劳尔·卡斯特罗表示，古方热烈欢迎李克强总理访古，此访具有重要历史意义。古方赞同中方对推进中古关系与合作的建议，愿在发展中学习借鉴中国经验，同中方密切高层交往，加强务实合作，扩大教育交流，在切实惠及两国人民的同时，加强在国际事务中的交流与合作，维护广大发展中国家的共同利益。");

        News news2 = new News("中办国办发文治“老赖”：考公务员入党将受限", "完善失信被执行人名单制度\n" +
                "\n" +
                "　　意见规定，法院要及时准确更新失信被执行人名单信息，并通过全国法院失信被执行人名单信息公布与查询平台、有关网站、移动客户端、户外媒体等多种形式向社会公开，供公众免费查询。通过全国信用信息共享平台，加快推进失信被执行人信息与公安、民政、人力资源社会保障、国土资源、住建、财政、金融、税务、工商、安全监管、证券、科技等部门信用信息资源共享。\n" +
                "\n" +
                "　　意见提出，进一步完善失信被执行人名单制度，完善名单的纳入制度，确保名单信息的准确规范，明确风险提示与救济、失信名单退出、惩戒措施解除以及责任追究等。进一步完善党政机关支持人民法院执行工作制度，加强协助执行工作，严格落实执行工作综治考核责任，明确党政机关干扰执行的责任追究。\n" +
                "\n" +
                "　　意见同时提出，要加大对失信被执行人名单和信用惩戒的宣传力度，依法将失信被执行人信息、受惩戒情况等公之于众，形成舆论压力，扩大失信被执行人名单制度的影响力和警示力。");

        News news3 = new News("中央军委科技委副主任辛毅晋升中将", " 据9月25日晚央视《军事报道》，全军副战区级以上单位纪委书记培训班19日至25日在国防大学举办。这是新体制下首次组织的大单位和军委机关部门纪委书记培训。报道画面显示，中央军委科技委副主任辛毅佩戴中将军衔出席会议。\n" +
                "　　辛毅曾任总装备部电子信息基础部部长；2015年1月升任总装备部科技委副主任，成为副大军区级将领。至迟在2016年2月，辛毅已转任中央军委科技委副主任，并出席公开活动。\n" +
                "　　国防部新闻局副局长、新闻发言人吴谦上校曾介绍，组建军委科技委，主要是加强国防科技战略管理，推动国防科技自主创新，协调推进科技领域军民融合发展。现任中央军委科技委主任是刘国治中将，副主任包括辛毅中将、贺福初少将。\n" +
                "　　此外，央视《军事报道》画面还显示了其他参加此次纪委书记培训班的将领。\n" +
                "　　其中来自中央军委15个职能部门的包括：军委办公厅副主任田义祥少将，军委联合参谋部参谋长助理马宜明中将，军委政治工作部主任助理崔昌军中将，军委装备发展部副部长张育林中将，军委训练管理部副部长方北群少将，军委国防动员部副部长胡宜树少将，军委纪委专职副书记杨成熙中将，军委科技委副主任辛毅中将，军委战略规划办公室副主任李广少将，军委改革和编制办公室副主任何仁学少将，军委审计署副审计长刘允喜少将，军委机关事务管理总局副局长高洪林少将。\n" +
                "　　来自战区的包括：东部战区副政委兼政治工作部主任王平中将，南部战区副政委兼政治工作部主任杨玉文中将，西部战区副政委何平少将，中部战区副政委兼政治工作部主任侯贺华中将。\n" +
                "　　来自各军兵种的包括：陆军纪委书记吴刚中将，海军纪委书记陈学斌少将，空军纪委书记宋琨中将，火箭军纪委书记陈平华中将，来自战略支援部队的吕建成中将，武警纪委书记王长河中将。\n");

        newses.add(news1);
        newses.add(news2);
        newses.add(news3);

        return newses;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = initNews();
        adapter = new NewsListAdapter(activity, R.layout.news_list_item, newsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_list_fragment, container, false);
        listView = (ListView)view.findViewById(R.id.news_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        News news = newsList.get(0);
        if (getActivity().findViewById(R.id.news_detail_layout) != null) {
            isTwoPage = true;
            NewsDetailFragment detailFragment = (NewsDetailFragment)getFragmentManager().findFragmentById(R.id.detail_fragment);
            detailFragment.refreash(news.getNewsTitle(), news.getNewsContent());
        }else {
            isTwoPage = false;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news = newsList.get(position);
        if (isTwoPage) {
            NewsDetailFragment detailFragment = (NewsDetailFragment)getFragmentManager().findFragmentById(R.id.detail_fragment);
            detailFragment.refreash(news.getNewsTitle(), news.getNewsContent());
        }else  {
            NewsDetailActivity.actionStart( getActivity(), news.getNewsTitle(), news.getNewsContent());
        }
    }
}
